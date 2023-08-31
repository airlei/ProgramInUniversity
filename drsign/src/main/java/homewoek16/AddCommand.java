package homewoek16;

import java.util.Stack;

public class AddCommand extends AbstractCommand {
    private Adder adder = new Adder();
    private Stack<Integer> unStack = new Stack<Integer>();// 返回栈，用来记录所做的每一步操作，用于撤回
    private Stack<Integer> reStack = new Stack<Integer>();// 重复栈，用来存储返回栈弹出的数据，由于重复
    /**
     * 撤回
     *
     */
    public int undo() {
        int i=0;
        if (unStack.isEmpty()) {

            i=-1;
        }else{
            Integer pop = unStack.pop();
            reStack.push(pop);
            if(!unStack.isEmpty()){//判断弹出数据后是否为空，如果为空，说明已撤回到最原始状态
                i=unStack.peek();
            }
        }
        return i;
    }

    /**
     * 恢复
     */
    public int redo() {
        int i=0;
        if (reStack.isEmpty()) {
            i=-1;
        }else{//撤回时只要可以可以撤回，则返回栈一定有数据
            Integer pop = reStack.pop();
            unStack.push(pop);
            i=pop;
        }
        return i;
    }

    /**
     * 执行计算，并进行栈的更新
     */
    public int execute(int value) {
        int v = 0;
        if (unStack.isEmpty()) {// 说明还没有数据
            v = adder.add(value);
            unStack.push(v);
        } else {// 需要更新两个栈中的内容，并计算结果,其中返回栈应该更新，重复栈应该清空
            v = adder.add(value);
            unStack.push(v);
            if (!reStack.isEmpty()) {
                for (int i = 0; i < reStack.size(); i++) {
                    reStack.pop();
                }
            }
        }
        return v;
    }
}

