package com.leetcode.bryan;

import com.leetcode.bryan.common.ListNode;
import com.leetcode.bryan.common.TreeNode;
import com.leetcode.bryan.easy.ReorderDatainLogFiles;
import com.leetcode.bryan.medium.AddTwoNumbers;
import com.leetcode.bryan.medium.AddTwoNumbersII;
import com.leetcode.bryan.medium.EqualTreePartition;
import com.leetcode.bryan.medium.MaximumAverageSubtree;


public class Main {

    public static void main(String[] args) {
    // test data
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(6);
        root.right = new TreeNode(1);
        //root.left.left = new TreeNode(4);
        //root.left.right = new TreeNode(5);
        //root.right.left = new TreeNode(6);
        //root.right.right = new TreeNode(7);

        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(3);

        ListNode l2 = new ListNode(7);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);


    // easy
        /*ArrayNesting a = new ArrayNesting();
        int[] nums = {5,4,0,3,1,6,2};
        int rlt = a.arrayNesting(nums);*/

        /*CheckIfStringIsaPrefixofArray c = new CheckIfStringIsaPrefixofArray();
        String s = "iloveleetcode";
        String words[] = {"app", "i","love","leetcode","apples"};
        boolean rlt = c.isPrefixString(s, words);*/

        /*ExcelSheetColumnTitle e = new ExcelSheetColumnTitle();
        String value = e.convertToTitle(2147483647);*/

        //int[] values = HowManyNumbersAreSmallerThantheCurrentNumber.smallerNumbersThanCurrent();

        /*MinimumDifferenceBetweenHighestandLowestofKScores m = new MinimumDifferenceBetweenHighestandLowestofKScores();
        int[] scores = {90};
        int rlt = m.minimumDifference(scores, 1);*/

        //MinimumTimetoTypeWordUsingSpecialTypewriter m = new MinimumTimetoTypeWordUsingSpecialTypewriter();
        //int value = m.minTimeToType("zjpc");

        //MinStack m = new MinStack();

        //boolean rlt = RectangleOverlap.isRectangleOverlap();

        /*String[] logs = {"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"};
        ReorderDatainLogFiles r = new ReorderDatainLogFiles();
        String[] rlt = r.reorderLogFiles(logs);*/

        /*ReplaceAllMarktoAvoidConsecutiveRepeatingCharacters r = new ReplaceAllMarktoAvoidConsecutiveRepeatingCharacters();
        r.modifyString();*/

        //ShortestWordDistance.shortestDistance();

        //int value = SingleNumber.singleNumber();

        /*SumofSquareNumbers s = new SumofSquareNumbers();
        boolean rlt = s.judgeSquareSum(2);*/

        //boolean rlt = ValidParentheses.isValid();


    // medium
        /*AddTwoNumbersII a = new AddTwoNumbersII();
        a.addTwoNumbers(l1, l2);*/

        /*int arr[] = {-2, -2, 1, -2, -1, 2};
        ArrayofDoubledPairs a = new ArrayofDoubledPairs();
        boolean rlt = a.canReorderDoubled(arr);*/

        /*ArrayWithElementsNotEqualtoAverageofNeighbors a = new ArrayWithElementsNotEqualtoAverageofNeighbors();
        int nums[] = {6, 2, 0, 9, 7};
        a.rearrangeArray(nums);*/

        //BoundaryofBinaryTree.boundaryOfBinaryTree();

        //ContainerWithMostWater.maxArea();

        //String rlt = DecodeString.decodeString();

        /*DecodeWays d = new DecodeWays();
        d.numDecodings("1116");*/

        /*DeleteNodesAndReturnForest d = new DeleteNodesAndReturnForest();
        int[] to_delete = {3, 5};
        d.delNodes(root, to_delete);*/

        //String rlt = FindAndReplaceinString.findReplaceString();

        /*FindMinimuminRotatedSortedArray f = new FindMinimuminRotatedSortedArray();
        int[] nums = {4,5,6,7,0,1,2};
        int rlt = f.findMin(nums);*/

        /*FindtheKthLargestIntegerintheArray f = new FindtheKthLargestIntegerintheArray();
        String[] nums = {"3", "6", "7", "10"};
        f.kthLargestNumber(nums, 4);*/

        /*FindUniqueBinaryString f = new FindUniqueBinaryString();
        String[] s = {"01", "10"};
        String rlt = f.findDifferentBinaryString(s);*/

        /*FlipStringtoMonotoneIncreasing f = new FlipStringtoMonotoneIncreasing();
        f.minFlipsMonoIncr("00110");*/

        /*GraphValidTree g = new GraphValidTree();
        int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}};
        int[][] edges = {{0, 1}, {0, 2}, {0, 3},{1, 4}};
        boolean rlt = g.validTree(5, edges);*/

        //GroupAnagrams.groupAnagrams();

        //int[][] rlt = InsertInterval.insert();

        /*LargestNumber l = new LargestNumber();
        String rlt = l.largestNumber();*/

        /*LonelyPixelI l = new LonelyPixelI();
        l.findLonelyPixel();*/

        /*LongestConsecutiveSequence l = new LongestConsecutiveSequence();
        int value = l.longestConsecutive();*/

        //LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring();

        /*LongestUncommonSubsequenceII l = new LongestUncommonSubsequenceII();
        String[] s = {"aba", "cdc", "eae"};
        String[] s = {"aabbcc", "aabbcc", "cb"};
        String[] s = {"aaa", "aaa", "aa"};
        String[] s = {"aabbcc", "aabbcc", "c", "e", "aabbcd"};
        String[] s = {"a","b","c","d","e","f","a","b","c","d","e","f"};
        int rlt = l.findLUSlength(s);*/

        /*MaximalNetworkRank m = new MaximalNetworkRank();
        m.maximalNetworkRank();*/

        /*MaximumAverageSubtree m = new MaximumAverageSubtree();
        m.maximumAverageSubtree(root);*/

        //int value = MaximumErasureValue.maximumUniqueSubarray();

        //int rlt = MaximumLengthofaConcatenatedStringwithUniqueCharacters.maxLength();

        /*MaximumMatrixSum m = new MaximumMatrixSum();
        int[][] data = {{-10, -10, -10}, {-10, -10, -10}, {-10, -10, -10}};
        long rlt = m.maxMatrixSum(data);*/

        /*MaximumProductofSplittedBinaryTree m = new MaximumProductofSplittedBinaryTree();
        m.maxProduct(root);*/

        /*MaximumProfitinJobScheduling m = new MaximumProfitinJobScheduling();
        int[] startTime = {1,2,3,3}, endTime = {3,4,5,6}, profit = {50,10,40,70};
        int[] startTime = {1,2,3,4,6}, endTime = {3,5,10,6,9}, profit = {20,20,100,70,60};
        int[] startTime = {1,2,2,3}, endTime = {2,5,3,4}, profit = {3,4,1,2};
        int[] startTime = {6,15,7,11,1,3,16,2}, endTime = {19,18,19,16,10,8,19,8}, profit = {2,9,1,19,5,7,3,19};
        int[] startTime = {43,13,36,31,40,5,47,13,28,16,2,11}, endTime = {44,22,41,41,47,13,48,35,48,26,21,39}, profit = {8,20,3,19,16,8,11,13,2,15,1,1};
        m.jobScheduling(startTime, endTime, profit);*/

        /*MergeIntervals m = new MergeIntervals();
        m.merge();*/

        /*MinimizetheDifferenceBetweenTargetandChosenElements m = new MinimizetheDifferenceBetweenTargetandChosenElements();
        int[][] mat = { {10,3,7,7,9,6,9,8,9,5},
                        {1,1,6,8,6,7,7,9,3,9},
                        {3,4,4,1,3,6,3,3,9,9},
                        {6,9,9,3,8,7,9,6,10,6} };
        int value = m.minimizeTheDifference(mat, 5);*/

        /*MinimumDeletionCosttoAvoidRepeatingLetters m = new MinimumDeletionCosttoAvoidRepeatingLetters();
        int rlt = m.minCost();*/

        /*MinimumDeletionstoMakeCharacterFrequenciesUnique m = new MinimumDeletionstoMakeCharacterFrequenciesUnique();
        //int value = m.minDeletions();*/

        //NumberofGoodWaystoSplitaString.numSplits();

        /*PartitionArrayintoDisjointIntervals p = new PartitionArrayintoDisjointIntervals();
        int rlt = p.partitionDisjoint();*/

        /*PatchingArray p = new PatchingArray();
        int[] nums = {1, 2, 31, 33};
        int rlt = p.minPatches(nums, 2147483647);*/

        /*PopulatingNextRightPointersinEachNode p = new PopulatingNextRightPointersinEachNode();
        p.connect();*/

        //ReconstructItinerary.findItinerary();

        //ReverseWordsinaString.reverseWords();

        /*SetMatrixZeroes s = new SetMatrixZeroes();
        int matrix[][] = {{0}};
        s.setZeroes(matrix);*/

        //SortColors.sortColors();

        //int rlt = TimeNeededtoInformAllEmployees.numOfMinutes();

        //ValidSquare.validSquare();

        /*VerifyPreorderSerializationofaBinaryTree v = new VerifyPreorderSerializationofaBinaryTree();
        String order = "9,9,9,#,9,9,9,9,9,9,#,#,9,#,#,#,#,9,9,9,9,#,9,#,9,#,#,#,#,9,9,#,9,#,#,9,9,#,#,9,9,#,9,#,#,9,#,#,9,9,9,9,#,9,#,#,9,9,#,#,9,9,9,#,#,9,#,#,9,#,#,9,#,#,#,9,9,9,9,9,9,#,9,9,9,#,#,#,#,9,#,#,9,9,#,9,#,9,#,9,9,#,#,#,9,9,9,#,9,9,9,#,#,#,9,#,#,9,9,#,9,#,#,9,9,#,#,9,#,#,9,#,#,9,9,#,9,9,#,#,#,9,9,#,#,#,9,9,9,#,9,9,#,9,#,#,#,9,#,9,#,9,#,#,9,9,#,9,#,9,#,#,9,9,#,#,9,9,#,9,9,#,#,#,9,#,9,9,#,9,#,9,#,#,#,9,9,9,9,9,9,9,#,#,#,9,9,9,#,9,#,#,#,9,#,#,#,9,9,#,#,9,9,#,#,9,9,9,9,#,#,#,9,#,#,#,9,9,#,#,#,9,9,#,#,#,9,9,9,9,9,9,#,#,9,#,9,#,#,9,#,#,9,9,9,#,#,#,9,#,9,#,#,9,9,#,9,#,9,9,9,#,#,9,#,#,#,9,#,9,#,#,9,#,9,9,#,#,9,#,#";
        v.isValidSerialization(order);*/

        /*EqualTreePartition e = new EqualTreePartition();
        boolean rlt = e.checkEqualTree(root);*/


    //hard
        //FirstMissingPositive.firstMissingPositive();

        /*MinimumWindowSubstring m = new MinimumWindowSubstring();
        String rlt = m.minWindow("ADOBECODEBANC", "ABC");*/

        /*RemoveBoxes r = new RemoveBoxes();
        int boxes[] = {1, 3, 2, 2, 2, 3, 4, 3, 1};
        int rlt = r.removeBoxes(boxes);*/

        /*SerializeandDeserializeNaryTree s = new SerializeandDeserializeNaryTree();
        String value = s.serialize();
        s.deserialize(value);*/




        System.out.println("============ End ============");
    }
}
