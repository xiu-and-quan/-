package 单调栈;

import java.util.LinkedList;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        //优先级队列
        OrderQueue orderList = new OrderQueue();
        int index = 0;
        int[] resList = new int[nums.length-k+1];
        for(int i = 0;i<nums.length;i++){
            if(i < k-1){
                orderList.push(nums[i]);
            }else{
                orderList.push(nums[i]);
                resList[index++]=orderList.maxValue();
                orderList.remove(nums[i-k+1]);
            }
        }
        return resList;
    }
}
class OrderQueue{
    public LinkedList<Integer> orderList = new LinkedList();

    public void push(int value){
        while(!orderList.isEmpty() && orderList.getLast() < value){
            orderList.pollLast();
        }
        orderList.addLast(value);
    }
    public void remove(int target){
        if(target == orderList.getFirst()){
            orderList.pollFirst();
        }
    }
    public int maxValue(){
        return orderList.getFirst();
    }
}
