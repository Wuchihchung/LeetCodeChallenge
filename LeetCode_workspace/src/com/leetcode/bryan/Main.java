package com.leetcode.bryan;

import com.leetcode.bryan.common.ListNode;
import com.leetcode.bryan.common.TreeNode;
import com.leetcode.bryan.easy.*;
import com.leetcode.bryan.hard.BestMeetingPoint;
import com.leetcode.bryan.medium.*;


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

        /*BasicCalculator b = new BasicCalculator();
        String s = "- (3 + (4 + 5))";
        b.calculate(s);*/

        /*BreakaPalindrome b = new BreakaPalindrome();
        String palindrome = "aba";
        String rlt = b.breakPalindrome(palindrome);*/

        /*CheckIfStringIsaPrefixofArray c = new CheckIfStringIsaPrefixofArray();
        String s = "iloveleetcode";
        String words[] = {"app", "i","love","leetcode","apples"};
        boolean rlt = c.isPrefixString(s, words);*/

        /*Convert1DArrayInto2DArray c = new Convert1DArrayInto2DArray();
        int[] original = {1,2};
        int[][] rlt = c.construct2DArray(original, 1, 1);*/

        /*ExcelSheetColumnTitle e = new ExcelSheetColumnTitle();
        String value = e.convertToTitle(2147483647);*/

        /*FindtheMiddleIndexinArray f = new FindtheMiddleIndexinArray();
        int[] nums = {2, 3, -1, 8, 99};
        f.findMiddleIndex(nums);*/

        /*FindWinneronaTicTacToeGame f = new FindWinneronaTicTacToeGame();
        int[][] moves = {{0,0},{1,1},{0,1},{0,2},{1,0},{2,0}};
        f.tictactoe(moves);*/

        //int[] values = HowManyNumbersAreSmallerThantheCurrentNumber.smallerNumbersThanCurrent();

        /*IntersectionofTwoArraysII i = new IntersectionofTwoArraysII();
        int[] nums1 = {4,9,5}, nums2 = {9,4,9,8,4};
        i.intersect(nums1, nums2);*/

        /*LongestTurbulentSubarray l = new LongestTurbulentSubarray();
        int[] arr = {0,1,1,0,1,0,1,1,0,0};
        int rlt = l.maxTurbulenceSize(arr);*/

        /*MaximumDifferenceBetweenIncreasingElements m = new MaximumDifferenceBetweenIncreasingElements();
        int[] nums = {87,68,91,86,58,63,43,98,6,66};
        int rlt = m.maximumDifference(nums);*/

        /*MaximumNumberofBalloons m = new MaximumNumberofBalloons();
        String text = "nlaebolkobbbbbbbbbbbbaaa";
        int rlt = m.maxNumberOfBalloons(text);*/

        /*MinimumDifferenceBetweenHighestandLowestofKScores m = new MinimumDifferenceBetweenHighestandLowestofKScores();
        int[] scores = {90};
        int rlt = m.minimumDifference(scores, 1);*/

        /*String s = "XXOX";
        MinimumMovestoConvertString m = new MinimumMovestoConvertString();
        int rlt = m.minimumMoves(s);*/

        //MinimumTimetoTypeWordUsingSpecialTypewriter m = new MinimumTimetoTypeWordUsingSpecialTypewriter();
        //int value = m.minTimeToType("zjpc");

        //MinStack m = new MinStack();

        /*NthTribonacciNumber n = new NthTribonacciNumber();
        int rlt = n.tribonacci(25);*/

        //boolean rlt = RectangleOverlap.isRectangleOverlap();

        /*String[] logs = {"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"};
        ReorderDatainLogFiles r = new ReorderDatainLogFiles();
        String[] rlt = r.reorderLogFiles(logs);*/

        /*ReplaceAllMarktoAvoidConsecutiveRepeatingCharacters r = new ReplaceAllMarktoAvoidConsecutiveRepeatingCharacters();
        r.modifyString();*/

        /*ReverseLinkedList r = new ReverseLinkedList();
        r.reverseList(l1);*/

        /*ReverseOnlyLetters r = new ReverseOnlyLetters();
        String s = "Test1ng-Leet=code-Q!";
        String rlt = r.reverseOnlyLetters(s);*/

        /*ReversePrefixofWord r = new ReversePrefixofWord();
        String word = "xyxzxe";
        char ch = 'z';
        String rlt = r.reversePrefix(word, ch);*/

        //ShortestWordDistance.shortestDistance();

        //int value = SingleNumber.singleNumber();

        /*int[] dur = {28,65,97};
        String keys = "gaf";
        SlowestKey s = new SlowestKey();
        s.slowestKey(dur, keys);*/

        /*SortArrayByParityII s = new SortArrayByParityII();
        int[] nums = {3,1,4,2};
        int[] rlt = s.sortArrayByParityII(nums);*/

        /*SumofSquareNumbers s = new SumofSquareNumbers();
        boolean rlt = s.judgeSquareSum(2);*/

        /*UniqueEmailAddresses u = new UniqueEmailAddresses();
        String[] emails = {"a@leetcode.com", "b@leetcode.com", "c@leetcode.com"};
        u.numUniqueEmails(emails);*/

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

        /*String s = "babgbag", t = "bag";
        DistinctSubsequences d = new DistinctSubsequences();
        int rlt = d.numDistinct(s, t);*/

        /*EqualTreePartition e = new EqualTreePartition();
        boolean rlt = e.checkEqualTree(root);*/

        //String rlt = FindAndReplaceinString.findReplaceString();

        /*FindMinimuminRotatedSortedArray f = new FindMinimuminRotatedSortedArray();
        int[] nums = {4,5,6,7,0,1,2};
        int rlt = f.findMin(nums);*/

        /*int[] rolls = {4,2,2,5,4,5,4,5,3,3,6,1,2,4,2,1,6,5,4,2,3,4,2,3,3,5,4,1,4,4,5,3,6,1,5,2,3,3,6,1,6,4,1,3};
        FindMissingObservations f = new FindMissingObservations();
        int[] rlt = f.missingRolls(rolls, 2, 53);*/

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

        /*MaximumAreaofaPieceofCakeAfterHorizontalandVerticalCuts m = new MaximumAreaofaPieceofCakeAfterHorizontalandVerticalCuts();
        int[] hs = {2};
        int[] vs = {2};
        int rlt = m.maxArea(1000000000, 1000000000, hs, vs);*/

        /*MaximumAverageSubtree m = new MaximumAverageSubtree();
        m.maximumAverageSubtree(root);*/

        //int value = MaximumErasureValue.maximumUniqueSubarray();

        //int rlt = MaximumLengthofaConcatenatedStringwithUniqueCharacters.maxLength();

        /*MaximumMatrixSum m = new MaximumMatrixSum();
        int[][] data = {{-10, -10, -10}, {-10, -10, -10}, {-10, -10, -10}};
        long rlt = m.maxMatrixSum(data);*/

        /*MaximumProductofSplittedBinaryTree m = new MaximumProductofSplittedBinaryTree();
        m.maxProduct(root);*/

        /*MergeIntervals m = new MergeIntervals();
        m.merge();*/

        /*MinimizeMaxDistancetoGasStation m = new MinimizeMaxDistancetoGasStation();
        int[] stations = {10,19,25,27,56,63,70,87,96,97};
        double rlt = m.minmaxGasDist(stations, 3);*/

        /*MinimizetheDifferenceBetweenTargetandChosenElements m = new MinimizetheDifferenceBetweenTargetandChosenElements();
        int[][] mat = { {10,3,7,7,9,6,9,8,9,5},
                        {1,1,6,8,6,7,7,9,3,9},
                        {3,4,4,1,3,6,3,3,9,9},
                        {6,9,9,3,8,7,9,6,10,6} };
        int value = m.minimizeTheDifference(mat, 5);*/

        /*MinimumCosttoConnectSticks m = new MinimumCosttoConnectSticks();
        //int[] sticks = {2,4,3};
        int[] sticks = {3354,4316,3259,4904,4598,474,3166,6322,8080,9009};
        m.connectSticks(sticks);*/

        /*MinimumDeletionCosttoAvoidRepeatingLetters m = new MinimumDeletionCosttoAvoidRepeatingLetters();
        int rlt = m.minCost();*/

        /*MinimumDeletionstoMakeCharacterFrequenciesUnique m = new MinimumDeletionstoMakeCharacterFrequenciesUnique();
        //int value = m.minDeletions();*/

        //NumberofGoodWaystoSplitaString.numSplits();

        /*NumberofPairsofInterchangeableRectangles n = new NumberofPairsofInterchangeableRectangles();
        int[][] rects = {{4,8},{3,6},{10,20},{15,30}};
        long rlt = n.interchangeableRectangles(rects);*/

        /*String[] nums = {"123","4","12","34"};
        String target = "1234";
        /*NumberofPairsofStringsWithConcatenationEqualtoTarget n = new NumberofPairsofStringsWithConcatenationEqualtoTarget();
        int rlt = n.numOfPairs(nums, target);*/

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

        /*ShiftingLetters s = new ShiftingLetters();
        String str = "xrdofd";
        int[] shifts = {70,41,71,72,73,84};
        s.shiftingLetters(str, shifts);*/

        //SortColors.sortColors();

        /*int[] nums = {1,2,3,4,5,7,8,9,10};
        SumofBeautyintheArray s = new SumofBeautyintheArray();
        int rlt = s.sumOfBeauties(nums);*/

        //int[][] properties = {{9,4}, {8,5}, {10,1}};
        //int[][] properties = {{1,5}, {10,4}, {4,3}};
        //int[][] properties = {{8,9}, {3,1}, {6,6}, {10,5}, {7,7}, {6,3}};
        //int[][] properties = {{1,1},{2,1},{2,2},{1,2}};
        //int[][] properties = {{7,9},{10,7},{6,9},{10,4},{7,5},{7,10}};
        /*int[][] properties = {{6,6},{6,6},{6,6},{6,6},{6,6},{6,6},{6,6},{6,6},{6,6}};
        TheNumberofWeakCharactersintheGame t = new TheNumberofWeakCharactersintheGame();
        int value = t.numberOfWeakCharacters(properties);*/

        //int rlt = TimeNeededtoInformAllEmployees.numOfMinutes();

        //ValidSquare.validSquare();

        /*VerifyPreorderSerializationofaBinaryTree v = new VerifyPreorderSerializationofaBinaryTree();
        String order = "9,9,9,#,9,9,9,9,9,9,#,#,9,#,#,#,#,9,9,9,9,#,9,#,9,#,#,#,#,9,9,#,9,#,#,9,9,#,#,9,9,#,9,#,#,9,#,#,9,9,9,9,#,9,#,#,9,9,#,#,9,9,9,#,#,9,#,#,9,#,#,9,#,#,#,9,9,9,9,9,9,#,9,9,9,#,#,#,#,9,#,#,9,9,#,9,#,9,#,9,9,#,#,#,9,9,9,#,9,9,9,#,#,#,9,#,#,9,9,#,9,#,#,9,9,#,#,9,#,#,9,#,#,9,9,#,9,9,#,#,#,9,9,#,#,#,9,9,9,#,9,9,#,9,#,#,#,9,#,9,#,9,#,#,9,9,#,9,#,9,#,#,9,9,#,#,9,9,#,9,9,#,#,#,9,#,9,9,#,9,#,9,#,#,#,9,9,9,9,9,9,9,#,#,#,9,9,9,#,9,#,#,#,9,#,#,#,9,9,#,#,9,9,#,#,9,9,9,9,#,#,#,9,#,#,#,9,9,#,#,#,9,9,#,#,#,9,9,9,9,9,9,#,#,9,#,9,#,#,9,#,#,9,9,9,#,#,#,9,#,9,#,#,9,9,#,9,#,9,9,9,#,#,9,#,#,#,9,#,9,#,#,9,#,9,9,#,#,9,#,#";
        v.isValidSerialization(order);*/



    //hard
        /*BestMeetingPoint b = new BestMeetingPoint();
        int[][] grid = {{1,0,0,0,1}, {0,0,0,0,0}, {0,0,1,0,0}};
        b.minTotalDistance(grid);*/

        //FirstMissingPositive.firstMissingPositive();

        /*MaximumProfitinJobScheduling m = new MaximumProfitinJobScheduling();
        int[] startTime = {1,2,3,3}, endTime = {3,4,5,6}, profit = {50,10,40,70};
        int[] startTime = {1,2,3,4,6}, endTime = {3,5,10,6,9}, profit = {20,20,100,70,60};
        int[] startTime = {1,2,2,3}, endTime = {2,5,3,4}, profit = {3,4,1,2};
        int[] startTime = {6,15,7,11,1,3,16,2}, endTime = {19,18,19,16,10,8,19,8}, profit = {2,9,1,19,5,7,3,19};
        int[] startTime = {43,13,36,31,40,5,47,13,28,16,2,11}, endTime = {44,22,41,41,47,13,48,35,48,26,21,39}, profit = {8,20,3,19,16,8,11,13,2,15,1,1};
        m.jobScheduling(startTime, endTime, profit);*/

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