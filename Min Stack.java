/**
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) – Push element x onto stack.
pop() – Removes the element on top of the stack.
top() – Get the top element.
getMin() – Retrieve the minimum element in the stack.
Note that all the operations have to be constant time operations.

Questions to ask the interviewer :

Q: What should getMin() do on empty stack? 
A: In this case, return -1.

Q: What should pop do on empty stack? 
A: In this case, nothing. 

Q: What should top() do on empty stack?
A: In this case, return -1

 */
class Solution {
    Stack<Integer> s;
    int me;
    
    public Solution(){
        s=new Stack<Integer>();
    }
    
    public void push(int x) {
        if (s.isEmpty()){
            s.push(x);
            me=x;
            return;
        }
        if(x<me){
            s.push(2*x-me);
            me=x;
        }
        else
            s.push(x);
    }

    public void pop() {
        if(s.isEmpty()){
            return;
        }
        int n = s.pop();
        if(n<me)
            me=2*me-n;
    }

    public int top() {
        if(s.isEmpty()){
            return -1;
        }
        int p = s.peek();
        int r=p;
        if (p<me)
            r=me;
        return r;
    }

    public int getMin() {
        if(s.isEmpty()){
            return -1;
        }
        return me;
    }
}
