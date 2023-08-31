import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.CompareOperator;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.filter.ColumnValueFilter;
import org.apache.hadoop.hbase.filter.FilterList;
import org.apache.hadoop.hbase.filter.SingleColumnValueFilter;
import org.apache.hadoop.hbase.util.Bytes;

import pojo.HBase;

import java.io.IOException;
import java.util.List;

public class HBaseDML {

    // 添加静态属性 connection 指向单例连接
    public static Connection connection = HBaseConnection.connection;


    /**
     * 插入数据
     * @param namespace 命名空间名称
     * @param tableName 表格名称
     * @param rowKey 主键
     * @param columnFamily 列族名称
     * @param columnName 列名
     * @param value 值
     */
    public static void putCell(String namespace,String tableName,String rowKey, String columnFamily,String columnName,String value) throws IOException {
        // 0. 判断表格是否存在
        if (!HBaseDDL.isTableExists(namespace,tableName)){
            System.out.println("表格不存在 无法删除");
            return ;
        }

        // 0. 获取 table
        Table table = connection.getTable(TableName.valueOf(namespace, tableName));
        // 1. 调用相关方法插入数据
        // 1.0 创建 put 对象
        Put put = new Put(Bytes.toBytes(rowKey));
        // 1.1. 给 put 对象添加数据

        put.addColumn(Bytes.toBytes(columnFamily),Bytes.toBytes(columnName),Bytes.toBytes(value));
        // 1.3 将对象写入对应的方法
        try {
            table.put(put);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 3. 关闭 table
        table.close();
    }


    /**
     * 读取数据 读取对应的一行中的某一列
     *
     * @param namespace 命名空间名称
     * @param tableName 表格名称
     * @param rowKey 主键
     * @param columnFamily 列族名称
     * @param columnName 列名
     */
    public static void getCells(String namespace, String tableName, String rowKey, String columnFamily, String columnName) throws IOException {
        // 0. 获取 table
        Table table = connection.getTable(TableName.valueOf(namespace, tableName));
        // 1. 创建 get 对象
        Get get = new Get(Bytes.toBytes(rowKey));
        // 如果直接调用 get 方法读取数据 此时读一整行数据
        // 如果想读取某一列的数据 需要添加对应的参数,直接把下面那一行注释

        get.addColumn(Bytes.toBytes(columnFamily), Bytes.toBytes(columnName));

        // 设置读取数据的版本
        get.readAllVersions();
        try {
            // 读取数据 得到 result 对象
            Result result = table.get(get);
            // 处理数据
            Cell[] cells = result.rawCells();
            // 测试方法: 直接把读取的数据打印到控制台
            // 如果是实际开发 需要再额外写方法 对应处理数据
            for (Cell cell : cells) {
                // cell 存储数据比较底层
                String value = new String(CellUtil.cloneValue(cell));
                System.out.println(value);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 关闭 table
        table.close();
    }



    /**
     * 扫描数据
     *
     * @param namespace 命名空间
     * @param tableName 表格名称
     * @param startRow 开始的 row 包含的
     * @param stopRow 结束的 row 不包含
     */
    public static void scanRows(String namespace, String tableName, String startRow, String stopRow) throws IOException {
// 0. 获取 table
        Table table = connection.getTable(TableName.valueOf(namespace, tableName));
        // 1. 创建 scan 对象
        Scan scan = new Scan();
        // 如果此时直接调用 会直接扫描整张表
        // 添加参数 来控制扫描的数据
        // 默认包含
        scan.withStartRow(Bytes.toBytes(startRow));
        // 默认不包含
        scan.withStopRow(Bytes.toBytes(stopRow));
        try {
            // 读取多行数据 获得 scanner
            ResultScanner scanner = table.getScanner(scan);
            // result 来记录一行数据 cell 数组
            // ResultScanner 来记录多行数据 result 的数组
            for (Result result : scanner) {
                Cell[] cells = result.rawCells();
                for (Cell cell : cells) {
                    System.out.print (new
                            String(CellUtil.cloneRow(cell)) + "-" + new
                            String(CellUtil.cloneFamily(cell)) + "-" + new
                            String(CellUtil.cloneQualifier(cell)) + "-" + new
                            String(CellUtil.cloneValue(cell)) + "\t");
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 3. 关闭 table
        table.close();
    }


/**
 * 带过滤的扫描
 *
 * @param namespace 命名空间
 * @param tableName 表格名称
 * @param startRow 开始 row
 * @param stopRow 结束 row
 * @param columnFamily 列族名称
 * @param columnName 列名
 * @param value value 值
 * @throws IOException
 */
public static void filterScan(String namespace, String tableName, String startRow, String stopRow, String columnFamily, String columnName, String value) throws IOException {
    // 0. 获取 table
    Table table = connection.getTable(TableName.valueOf(namespace, tableName));
    // 1. 创建 scan 对象
    Scan scan = new Scan();
    // 如果此时直接调用 会直接扫描整张表
    // 添加参数 来控制扫描的数据
    // 默认包含
    scan.withStartRow(Bytes.toBytes(startRow));
    // 默认不包含
    scan.withStopRow(Bytes.toBytes(stopRow));
    // 可以添加多个过滤
    FilterList filterList = new FilterList();
    // 创建过滤器
    // (0) 结果只保留当前列的数据
    ColumnValueFilter columnValueFilter = new ColumnValueFilter(
            // 列族名称
            Bytes.toBytes(columnFamily),
            // 列名
            Bytes.toBytes(columnName),
            // 比较关系
            CompareOperator.EQUAL,
            // 值
            Bytes.toBytes(value)
    );
    // (1) 结果保留整行数据
    // 结果同时会保留没有当前列的数据
    SingleColumnValueFilter singleColumnValueFilter = new SingleColumnValueFilter(
            // 列族名称
            Bytes.toBytes(columnFamily),
            // 列名
            Bytes.toBytes(columnName),
            // 比较关系
            CompareOperator.EQUAL,
            // 值
            Bytes.toBytes(value)
    );
    // 本身可以添加多个过滤器
    filterList.addFilter(singleColumnValueFilter);
    // 添加过滤
    scan.setFilter(filterList);
    try {
        // 读取多行数据 获得 scanner
        ResultScanner scanner = table.getScanner(scan);
        // result 来记录一行数据 cell 数组
        // ResultScanner 来记录多行数据 result 的数组
        for (Result result : scanner) {
            Cell[] cells = result.rawCells();
            for (Cell cell : cells) {
                System.out.print(new
                        String(CellUtil.cloneRow(cell)) + "-" + new
                        String(CellUtil.cloneFamily(cell)) + "-" + new
                        String(CellUtil.cloneQualifier(cell)) + "-" + new
                        String(CellUtil.cloneValue(cell)) + "\t");
            }
            System.out.println();
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    // 3. 关闭 table
    table.close();
}




    /**
     * 删除 column 数据
     *
     * @param nameSpace
     * @param tableName
     * @param rowKey
     * @param family
     * @param column
     * @throws IOException
     */
    public static void deleteColumn(String nameSpace, String tableName, String rowKey, String family, String column) throws IOException {
        // 0.获取 table
        Table table = connection.getTable(TableName.valueOf(nameSpace,
                tableName));
        // 1.创建 Delete 对象
        Delete delete = new Delete(Bytes.toBytes(rowKey));
        // 3.添加删除信息
        // 3.0 删除单个版本
//
        delete.addColumn(Bytes.toBytes(family),Bytes.toBytes(column));
        // 3.1 删除所有版本
        delete.addColumns(Bytes.toBytes(family),
                Bytes.toBytes(column));
        // 3.3 删除列族
// delete.addFamily(Bytes.toBytes(family));
        // 3.删除数据
        table.delete(delete);
        // 5.关闭资源
        table.close();
    }



    public static HBase scanColumn (String tableName, String column) throws IOException {
        Table table = connection.getTable(TableName.valueOf(tableName));
        Get get = new Get(Bytes.toBytes(column));
        //拿到以上要求的所有数据
        Result result = table.get(get);
        HBase hbase = new HBase();
        //将数据值放到一个数组中
        List<Cell> cells = result.listCells();
        hbase.setId(Integer.parseInt(Bytes.toString(cells.get(0).getValueArray(),cells.get(0).getValueOffset(),cells.get(0).getValueLength())));
        hbase.setName(Bytes.toString(cells.get(1).getValueArray(),cells.get(1).getValueOffset(),cells.get(1).getValueLength()));
        hbase.setRegion(Bytes.toString(cells.get(2).getValueArray(),cells.get(2).getValueOffset(),cells.get(2).getValueLength()));
        hbase.setRequest(Bytes.toString(cells.get(3).getValueArray(),cells.get(3).getValueOffset(),cells.get(3).getValueLength()));
        hbase.setActivity(Bytes.toString(cells.get(4).getValueArray(),cells.get(4).getValueOffset(),cells.get(4).getValueLength()));
        hbase.setOrganization(Bytes.toString(cells.get(5).getValueArray(),cells.get(5).getValueOffset(),cells.get(5).getValueLength()));

        System.out.println(hbase.toString());

        table.close();
        return hbase;}

/*
    public ArrayList<Hbase> scanAll(String tableName) throws IOException {

        Table table = connection.getTable(TableName.valueOf(tableName));
        Scan scan = new Scan();
        ArrayList<Hbase> hbases = new ArrayList<>();
        ResultScanner resultScanner = table.getScanner(scan);
        for (Result result : resultScanner) {
            Hbase hbase = new Hbase();
            //将数据值放到一个数组中
            List<Cell> cells = result.listCells();
            System.out.println(Bytes.toString(cells.get(0).getValueArray(),cells.get(0).getValueOffset(),cells.get(0).getValueLength()));
            hbase.setCz(Bytes.toString(cells.get(0).getValueArray(),cells.get(0).getValueOffset(),cells.get(0).getValueLength()));
            hbase.setDwwz(Bytes.toString(cells.get(1).getValueArray(),cells.get(1).getValueOffset(),cells.get(1).getValueLength()));
            hbase.setDzyx(Bytes.toString(cells.get(3).getValueArray(),cells.get(3).getValueOffset(),cells.get(3).getValueLength()));
            hbase.setFrdb(Bytes.toString(cells.get(4).getValueArray(),cells.get(4).getValueOffset(),cells.get(4).getValueLength()));
            hbase.setGddh(Bytes.toString(cells.get(5).getValueArray(),cells.get(5).getValueOffset(),cells.get(5).getValueLength()));
            hbase.setGkglbm(Bytes.toString(cells.get(6).getValueArray(),cells.get(6).getValueOffset(),cells.get(6).getValueLength()));
            hbase.setJgjj(Bytes.toString(cells.get(7).getValueArray(),cells.get(7).getValueOffset(),cells.get(7).getValueLength()));
            hbase.setJgmc(Bytes.toString(cells.get(8).getValueArray(),cells.get(8).getValueOffset(),cells.get(8).getValueLength()));
            hbase.setJgsx(Bytes.toString(cells.get(9).getValueArray(),cells.get(9).getValueOffset(),cells.get(9).getValueLength()));
            hbase.setJsxqmc(Bytes.toString(cells.get(00).getValueArray(),cells.get(00).getValueOffset(),cells.get(00).getValueLength()));
            hbase.setLxr(Bytes.toString(cells.get(00).getValueArray(),cells.get(00).getValueOffset(),cells.get(00).getValueLength()));
            hbase.setSzdy(Bytes.toString(cells.get(01).getValueArray(),cells.get(01).getValueOffset(),cells.get(01).getValueLength()));
            hbase.setTxdz(Bytes.toString(cells.get(03).getValueArray(),cells.get(03).getValueOffset(),cells.get(03).getValueLength()));
            hbase.setYddh(Bytes.toString(cells.get(04).getValueArray(),cells.get(04).getValueOffset(),cells.get(04).getValueLength()));
            hbase.setYzbm(Bytes.toString(cells.get(05).getValueArray(),cells.get(05).getValueOffset(),cells.get(05).getValueLength()));

            hbases.add(hbase);
            System.out.println(hbase.toString());
        }
        table.close();
        return hbases;

    }


*/


//    public static void main(String[] args) throws IOException {
// putCell("bigdata","student","0001","info","name","lisi");
// String cell = getCell("bigdata", "student", "0000", "info","name");
// System.out.println(cell);
// List<String> strings = scanRows("bigdata", "student","0000", "1000");
// for (String string : strings) {
// System.out.println(string);
// deleteColumn("bigdata", "student", "0000", "info", "name");
//    }


    public static void main(String[] args) throws IOException {
        //插入数据
//        putCell("bigdata","Student","1000","info","name","zhangsan");
            //读取数据
//            getCells("bigdata","Student","000","info","S_Name");

        //扫描数据
        System.out.println("*********************************************************");
        scanRows("bigdata","hbase","000","001");
        System.out.println("*********************************************************");

          scanColumn("bigdata:hbase","id");

/*        putCell("bigdata","hbase","001","id","id","1");
        putCell("bigdata","hbase","001","info","name","1");
        putCell("bigdata","hbase","001","info","region","1");
        putCell("bigdata","hbase","001","info","request","1");
        putCell("bigdata","hbase","001","info","activity","1");
        putCell("bigdata","hbase","001","info","organization","1");*/


        HBaseConnection.closeConnection();
    }
}
