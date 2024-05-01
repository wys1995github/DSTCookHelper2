package main.java.dstch.util;

import javafx.collections.ObservableList;
import main.java.dstch.bean.CDBean;
import main.java.dstch.bean.FIBean;

/**
 * @Description : 排序工具类，快速排序
 * @Author : wys
 * @Date : 2023/2/26 13:59
 */
public class SortUtil {

    public static final int ORDERTYPE_ASC = 1;//升序
    public static final int ORDERTYPE_DESC = 0;//降序

    public static ObservableList<CDBean> CDBeanSort(ObservableList<CDBean> arr, int leftBound, int rightBound, String keyType, int orderType) {
        if(leftBound >= rightBound) {
            return arr;
        }
        int mid = cdPartition(arr, leftBound, rightBound, keyType, orderType); //得到轴的位置
        CDBeanSort(arr, leftBound, mid-1, keyType, orderType); //左边排序
        CDBeanSort(arr, mid+1, rightBound, keyType, orderType); //右边排序
        return arr;
    }

    private static int cdPartition(ObservableList<CDBean> arr, int leftBound, int rightBound, String keyType, int orderType) {
        float pivot = arr.get(rightBound).getHunger(); //指定数组最右边的数是用来比较的值轴
        switch (keyType){
            case "饥饿值":
                pivot = arr.get(rightBound).getHunger();
                break;
            case "精神值":
                pivot = arr.get(rightBound).getSanity();
                break;
            case "生命值":
                pivot = arr.get(rightBound).getHealth();
                break;
            default:
                break;
        }
        int left = leftBound;
        int right = rightBound - 1;
        if(orderType == ORDERTYPE_ASC){//升序
            while (left <= right) {
                switch (keyType){
                    case "饥饿值":
                        while(left <= right && arr.get(left).getHunger() <= pivot) left++;
                        while(left <= right && arr.get(right).getHunger() > pivot) right--;
                        break;
                    case "精神值":
                        while(left <= right && arr.get(left).getSanity() <= pivot) left++;
                        while(left <= right && arr.get(right).getSanity() > pivot) right--;
                        break;
                    case "生命值":
                        while(left <= right && arr.get(left).getHealth() <= pivot) left++;
                        while(left <= right && arr.get(right).getHealth() > pivot) right--;
                        break;
                    default:
                        break;
                }
                if (left < right) {
                    //如果 左边的数比右边的数小  两个数交换
                    CDBean temp = arr.get(left);
                    arr.set(left, arr.get(right));
                    arr.set(right, temp);
                }
            }
            CDBean temp = arr.get(left);
            arr.set(left, arr.get(rightBound));
            arr.set(rightBound, temp);
            return left; //返回轴的位置
        }else {//降序
            while (left <= right) {
                switch (keyType){
                    case "饥饿值":
                        while(left <= right && arr.get(left).getHunger() >= pivot) left++;
                        while(left <= right && arr.get(right).getHunger() < pivot) right--;
                        break;
                    case "精神值":
                        while(left <= right && arr.get(left).getSanity() >= pivot) left++;
                        while(left <= right && arr.get(right).getSanity() < pivot) right--;
                        break;
                    case "生命值":
                        while(left <= right && arr.get(left).getHealth() >= pivot) left++;
                        while(left <= right && arr.get(right).getHealth() < pivot) right--;
                        break;
                    default:
                        break;
                }
                if (left < right) {
                    //如果 左边的数比右边的数小  两个数交换
                    CDBean temp = arr.get(left);
                    arr.set(left, arr.get(right));
                    arr.set(right, temp);
                }
            }
            CDBean temp = arr.get(left);
            arr.set(left, arr.get(rightBound));
            arr.set(rightBound, temp);
            return left; //返回轴的位置
        }
    }

    public static ObservableList<FIBean> FIBeanSort(ObservableList<FIBean> arr, int leftBound, int rightBound, String keyType, int orderType) {
        if(leftBound >= rightBound) {
            return arr;
        }
        int mid = fiPartition(arr, leftBound, rightBound, keyType, orderType); //得到轴的位置
        FIBeanSort(arr, leftBound, mid-1, keyType, orderType); //左边排序
        FIBeanSort(arr, mid+1, rightBound, keyType, orderType); //右边排序
        return arr;
    }

    private static int fiPartition(ObservableList<FIBean> arr, int leftBound, int rightBound, String keyType, int orderType) {
        float pivot = arr.get(rightBound).getHunger(); //指定数组最右边的数是用来比较的值轴
        switch (keyType){
            case "饥饿值":
                pivot = arr.get(rightBound).getHunger();
                break;
            case "精神值":
                pivot = arr.get(rightBound).getSanity();
                break;
            case "生命值":
                pivot = arr.get(rightBound).getHealth();
                break;
            default:
                break;
        }
        int left = leftBound;
        int right = rightBound - 1;
        if(orderType == ORDERTYPE_ASC){//升序
            while (left <= right) {
                switch (keyType){
                    case "饥饿值":
                        while(left <= right && arr.get(left).getHunger() <= pivot) left++;
                        while(left <= right && arr.get(right).getHunger() > pivot) right--;
                        break;
                    case "精神值":
                        while(left <= right && arr.get(left).getSanity() <= pivot) left++;
                        while(left <= right && arr.get(right).getSanity() > pivot) right--;
                        break;
                    case "生命值":
                        while(left <= right && arr.get(left).getHealth() <= pivot) left++;
                        while(left <= right && arr.get(right).getHealth() > pivot) right--;
                        break;
                    default:
                        break;
                }
                if (left < right) {
                    //如果 左边的数比右边的数小  两个数交换
                    FIBean temp = arr.get(left);
                    arr.set(left, arr.get(right));
                    arr.set(right, temp);
                }
            }
            FIBean temp = arr.get(left);
            arr.set(left, arr.get(rightBound));
            arr.set(rightBound, temp);
            return left; //返回轴的位置
        }else {//降序
            while (left <= right) {
                switch (keyType){
                    case "饥饿值":
                        while(left <= right && arr.get(left).getHunger() >= pivot) left++;
                        while(left <= right && arr.get(right).getHunger() < pivot) right--;
                        break;
                    case "精神值":
                        while(left <= right && arr.get(left).getSanity() >= pivot) left++;
                        while(left <= right && arr.get(right).getSanity() < pivot) right--;
                        break;
                    case "生命值":
                        while(left <= right && arr.get(left).getHealth() >= pivot) left++;
                        while(left <= right && arr.get(right).getHealth() < pivot) right--;
                        break;
                    default:
                        break;
                }
                if (left < right) {
                    //如果 左边的数比右边的数小  两个数交换
                    FIBean temp = arr.get(left);
                    arr.set(left, arr.get(right));
                    arr.set(right, temp);
                }
            }
            FIBean temp = arr.get(left);
            arr.set(left, arr.get(rightBound));
            arr.set(rightBound, temp);
            return left; //返回轴的位置
        }
    }

}
