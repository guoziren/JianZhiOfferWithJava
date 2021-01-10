package com.ustc.interview.problem26;

import com.ustc.common.TreeNode;
import com.ustc.zuoshen.day04.BinaryTree;
import org.junit.Test;

public class JZ26 {
    public boolean isSubStructure3(TreeNode A, TreeNode B) {
        if(A == null && B == null ){
            return true;
        }
        if((A != null && B == null) ||
                (A == null && B != null)){
            return false;
        }
        boolean rRoot = (A.val == B.val);
        boolean rLeft = false, rRight = false;
        if(rRoot){
            rLeft = isSubStructure3(A.left,B.left);
            rRight = isSubStructure3(A.right,B.right);
            return  rLeft && rRight;
        }else{
            rLeft = isSubStructure3(A.left,B);
            rRight = isSubStructure3(A.right,B);
            return rLeft || rRight;
        }

    }
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        boolean result = false;
        if (A != null && B != null){
            if (A.val == B.val){
                result = compare(A,B);
            }
            if (!result){
                result = isSubStructure(A.left,B);
            }
            if (!result){
                result = isSubStructure(A.right,B);
            }
        }
        return result;
    }

    private boolean compare(TreeNode A, TreeNode B) {
        if(B == null ){
            return true;
        }else{
            if( A == null || (A != null && A.val != B.val )){
                return false;
            }
        }


        boolean b1 = compare(A.left,B.left);
        if (!b1){
            return false;
        }
        boolean b2 = compare(A.right,B.right);
        if (!b2){
            return false;
        }else{
            return true;
        }
    }



    @Test
    public void test(){
        BinaryTree tree = new BinaryTree();
        tree.reconByPreString("1,2,#,#,3,#,#,");

//        Assert.assertEquals(true,isSubStructure( tree.reconByPreString("1,2,#,#,3,#,#,"), tree.reconByPreString("1,2,#,#,3,#,#,")));
//        Assert.assertEquals(false,isSubStructure( tree.reconByPreString("1,2,#,#,3,#,#,"), tree.reconByPreString("1,4,#,#,#,")));
//        Assert.assertEquals(true,isSubStructure( tree.reconByPreString("2,1,2,#,#,3,#,#,3,#,#,"), tree.reconByPreString("1,2,#,#,3,#,#,")));
//        Assert.assertEquals(true,isSubStructure( tree.reconByPreString("1,2,#,#,3,#,#,"), tree.reconByPreString("1,2,#,#,3,#,#,")));
//        Assert.assertEquals(false,isSubStructure( tree.reconByPreString("1,2,#,#,3,#,#,"), tree.reconByPreString("1,4,#,#,#,")));

    }
}
