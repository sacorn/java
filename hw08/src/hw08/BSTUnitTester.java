package hw08;



/*
NOTE: TO use this tester, it must be in the same package as your BST and the root of your BST
must be switched to public or protected (for testing only).
All data fields in BSTNode must also be protected.
All methods that have visibility errors because they are private, should be made protected to work with this tester.

This class has a main method so simply run this class.

 */

import java.util.ArrayList;

public class BSTUnitTester {

    //Widths for string formatting
    private static int TEST_NAME_WIDTH = -35;
    private static String INDENT_WIDTH_1 = "   ";
    private static String INDENT_WIDTH_2 = "      ";
    private static String INDENT_WIDTH_3 = "         ";
    private static int RESULTS_WIDTH = -20;

    //Format strings for the String.format() method.
    private static String FORMAT_1 = "%" + TEST_NAME_WIDTH + "s";
    private static String FORMAT_2 = "\n" + INDENT_WIDTH_1 + "%" + RESULTS_WIDTH + "s%s";
    private static String FORMAT_3 = "\n" + INDENT_WIDTH_2 + "%-15s%-20s%-20s";

    
    private boolean verbose = false;
    private BinarySearchTree<String> bst;
    private ArrayList<BSTNode<String>> inorderList;

    public static void main(String[] args) {
    	BSTUnitTester bstu = new BSTUnitTester(true);
    	bstu.runUnitTests();
    }
    
    public BSTUnitTester() {
        this.verbose = false;
    }

    public BSTUnitTester(boolean verbose) {
        this.verbose = verbose;
    }

    public void runUnitTests() {

    	System.out.println("Running insertion test....");
        boolean insertTestPassed = this.insertTest();
        if (!insertTestPassed) {
            System.out.println("\nFUNDAMENTAL ERROR: Insertion test failed, cannot continue testing program.");
            System.out.println("Unit Tester will now exit");
            System.exit(1);
        }
        System.out.println();

        System.out.println("Running array constructor test....");
        this.arrayConstructorTest();
        System.out.println();

        System.out.println("Running insert parent test....");
        this.insertParentTest();
        System.out.println();

        System.out.println("Running delete test....");
        this.deleteTest();
        System.out.println();
        
        System.out.println("Running delete parent test....");
        this.deleteParentTest();
        System.out.println();
        
        System.out.println("Running find test....");
        this.findTester();
        System.out.println();
        
        System.out.println("Running leaf test....");
        this.leafTester();
        System.out.println();
        
        System.out.println("Running left child test....");
        this.leftChildTester();
        System.out.println();
        
        System.out.println("Running right child test....");
        this.rightChildTester();
        System.out.println();
        
        System.out.println("Running preorder test....");
        this.preorderTester();
        System.out.println();
        
        System.out.println("Running inorder test....");
        this.inorderTester();
        System.out.println();
        
        System.out.println("Running postorder test....");
        this.postorderTester();
        System.out.println();
        
        System.out.println("Running breadthfirst test....");
        this.breadthfirstTester();
    }

    
    
    private boolean insertTest() {
    	
        boolean insertTestPassed = false;

        //Create the BST that will be used throughout.
        this.bst = new BinarySearchTree<>();

        String testOutput = String.format(FORMAT_1, "insert() Test:");

        //Collects any errors that pop up.
        String errors = "";

        //Collects any additional information about the current test.
        String msg = "";

        try {

            //All letters from a to z.
            String testData = "mtpsbyfjdxcnelqhgaurzwikov";

            msg += "\n" + INDENT_WIDTH_1 + "Inserting the following values:";

            //Insert each letter one at a time into the tree.
            //If the insert method throws an exception, fails the test.
            for (int i = 0 ; i < testData.length() ; i++) {
                msg += "\n" + INDENT_WIDTH_2 + "insert(" + testData.charAt(i) + ")";
                this.bst.insert(Character.toString(testData.charAt(i)));
            }
            msg += "\n" + INDENT_WIDTH_1 + "Performing inorder traversal and checking results...";

            //Get the inorder traversal of the data (should be the alphabet from a - z).
            String expected = "abcdefghijklmnopqrstuvwxyz";
            String results = this.myInorder(bst.root);

            //Test to make sure order is correct.
            if (expected.equals(results)) {
                insertTestPassed = true;
            }
            else {
                errors += String.format(FORMAT_2, "Expected Inorder:", expected);
                errors += String.format(FORMAT_2, "Result Inorder:", results);
            }
        }
        catch (Exception ex) {
           testOutput += "FAIL (" + ex + ")";

           errors += handleException(ex);

           testOutput += (this.verbose) ? msg : "";
           testOutput += (this.verbose) ? errors : "";
           System.out.println(testOutput);
           return false;
        }

        if (insertTestPassed) {
            testOutput += "PASS";
            testOutput += (verbose) ? msg : "";
        }
        else {
            testOutput += "FAIL (Values are not inserted correctly)";
            testOutput += (this.verbose) ? msg : "";
            testOutput += (this.verbose) ? errors : "";
        }

        System.out.println(testOutput);

        return insertTestPassed;
    }

    private void arrayConstructorTest() {
        boolean arrayConstructorTestPassed = false;
        String testOutput = String.format(FORMAT_1, "BinarySearchTree(arr[]) Test:");
        String errors = "";
        String msg = "";

        try {
            String[] arr = {"m", "t", "p", "s", "b", "y", "f", "j", "d", "x", "c", "n", "e",
                            "l", "q", "h", "g", "a", "u", "r", "z", "w", "i", "k", "o", "v"};

            msg += "\n" + INDENT_WIDTH_1 + "Running array constructor test...";

            BinarySearchTree<String> bst = new BinarySearchTree<>(arr);

            msg += "\n" + INDENT_WIDTH_1 + "Performing inorder traversal and checking results...";

            //Get the inorder traversal of the data (should be the alphabet from a - z).
            String expected = "abcdefghijklmnopqrstuvwxyz";
            String results = this.myInorder(bst.root);

            //Test to make sure order is correct.
            if (expected.equals(results)) {
                arrayConstructorTestPassed = true;
            }
            else {
                errors += String.format(FORMAT_2, "Expected Inorder:", expected);
                errors += String.format(FORMAT_2, "Result Inorder:", results);
            }

        }
        catch (Exception ex) {
            testOutput += "FAIL (" + ex + ")";

            errors += handleException(ex);

            testOutput += (this.verbose) ? msg : "";
            testOutput += (this.verbose) ? errors : "";
            System.out.println(testOutput);
            return;
        }

        if (arrayConstructorTestPassed) {
            testOutput += "PASS";
            testOutput += (this.verbose) ? msg : "";
        }
        else {
            testOutput += "FAIL (Array constructor did not insert values correctly.)";
            testOutput += (this.verbose) ? msg : "";
            testOutput += (this.verbose) ? errors : "";
        }

        System.out.println(testOutput);
    }

    //Tests to see if the parent references are correct by starting from a leaf and following
    //  the parents back to the root.
    private void insertParentTest() {
        boolean insertParentTestPassed = true;
        String testOutput = String.format(FORMAT_1, "Parent After insert() Test:");
        String errors = "";
        String msg = "";

        //These are the hardcoded expected paths from each leaf to the root.
        String[] expectedPaths = {"a->b->m", "c->d->f->b->m", "e->d->f->b->m", "g->h->j->f->b->m",
                                  "i->h->j->f->b->m", "k->l->j->f->b->m", "o->n->p->t->m",
                                  "r->q->s->p->t->m", "v->w->u->x->y->t->m", "z->y->t->m"};

        try {
            msg += "\n" + INDENT_WIDTH_1 + "Getting a list of leaves...";

            //Get a list of all the leaves.
            ArrayList<BSTNode<String>> leaves = this.filterLeaves();


            msg += "\n" + INDENT_WIDTH_1 + "Tracing path from each leaf to the root...";
            for (int i = 0; i < leaves.size(); i++) {
                String path = "";
                BSTNode<String> current = leaves.get(i);

                while (current != null) {
                    path += current.data;

                    if (!current.data.equals(this.bst.root.data)) {
                        path  += "->";
                    }
                    current = current.parent;
                }

                if(!path.equals(expectedPaths[i])) {
                    insertParentTestPassed = false;
                    errors += String.format(FORMAT_2, "*Expected Path:", expectedPaths[i]);
                    errors += String.format(FORMAT_2, "*Result Path:", path);
                }
                else {
                    errors += String.format(FORMAT_2, "Expected Path:", expectedPaths[i]);
                    errors += String.format(FORMAT_2, "Result Path:", path);
                }
            }
        }
        catch (Exception ex) {
            testOutput += "FAIL (" + ex + ")";

            errors += handleException(ex);

            testOutput += (this.verbose) ? msg : "";
            testOutput += (this.verbose) ? errors : "";
            System.out.println(testOutput);
            return;
        }

        if (insertParentTestPassed) {
            testOutput += "PASS";
            testOutput += (this.verbose) ? msg : "";
        }
        else {
            testOutput += "FAIL (Parent references not correctly connected. See asterisk *)";
            testOutput += (this.verbose) ? msg : "";
            testOutput += (this.verbose) ? errors : "";
        }

        System.out.println(testOutput);
    }

    private void deleteTest() {
        boolean deleteTestPassed = false;
        String testOutput = String.format(FORMAT_1, "delete() Test:");
        String errors = "";
        String msg ="";

        try {
            String[] valuesToDelete = {"m", "o", "f", "q"};

            msg += "\n" + INDENT_WIDTH_1 + "Deleting the following values:";

            for (int i = 0 ; i < valuesToDelete.length ; i++) {
                msg += "\n" + INDENT_WIDTH_2 + "delete(" + valuesToDelete[i] + ")";
                this.bst.delete(valuesToDelete[i]);
            }

            //Get the inorder traversal of the data (should be the alphabet from a - z).
            String expected = "abcdeghijklnprstuvwxyz";
            String results = this.myInorder(bst.root);

            msg += "\n" + INDENT_WIDTH_1 + "Performing inorder traversal and checking results...";

            //Test to make sure order is correct.
            if (expected.equals(results)) {
                deleteTestPassed = true;
            }
            else {
                errors += String.format(FORMAT_2, "Expected Inorder:", expected);
                errors += String.format(FORMAT_2, "Result Inorder:", results);
            }
        }
        catch (Exception ex) {
            testOutput += "FAIL (" + ex + ")";

            errors += handleException(ex);

            testOutput += (this.verbose) ? msg : "";
            testOutput += (this.verbose) ? errors : "";
            System.out.println(testOutput);
            return;
        }

        if (deleteTestPassed) {
            testOutput += "PASS";
            testOutput += (verbose) ? msg : "";
        }
        else {
            testOutput += "FAIL (Tree delete does not work properly.)";
            testOutput += (this.verbose) ? msg : "";
            testOutput += (this.verbose) ? errors : "";
        }

        System.out.println(testOutput);
    }

    private void deleteParentTest() {
        boolean deleteParentTestPassed = true;
        String testOutput = String.format(FORMAT_1, "Parent After delete() Test:");
        String errors = "";
        String msg = "";

        String[] expectedPaths = {"a->b->l", "c->d->e->b->l", "g->h->j->e->b->l", "i->h->j->e->b->l", "k->j->e->b->l",
                                  "n->p->t->l", "r->s->p->t->l", "v->w->u->x->y->t->l", "z->y->t->l"};

        try {
        	msg += "\n" + INDENT_WIDTH_1 + "Getting a list of leaves...";

            ArrayList<BSTNode<String>> leaves = this.filterLeaves();

            msg += "\n" + INDENT_WIDTH_1 + "Tracing path from each leaf to the root...";
            for (int i = 0; i < leaves.size(); i++) {
                String path = "";
                BSTNode<String> current = leaves.get(i);
                //msg += "\n";

                while (current != null) {
                    path += current.data;

                    if (!current.data.equals(this.bst.root.data)) {
                        path  += "->";
                    }
                    current = current.parent;
                }

                if(!path.equals(expectedPaths[i])) {
                    deleteParentTestPassed = false;
                    errors += String.format(FORMAT_2, "*Expected Path:", expectedPaths[i]);
                    errors += String.format(FORMAT_2, "*Result Path:", path);
                }
                else {
                	errors += String.format(FORMAT_2, "Expected Path:", expectedPaths[i]);
                    errors += String.format(FORMAT_2, "Result Path:", path);
                }
            }
        }
        catch (Exception ex) {
        	testOutput += "FAIL (" + ex + ")";

            errors += handleException(ex);

            testOutput += (this.verbose) ? msg : "";
            testOutput += (this.verbose) ? errors : "";
            System.out.println(testOutput);
            return;
        }

        if (deleteParentTestPassed) {
            testOutput += "PASS";
            testOutput += (verbose) ? msg : "";
        }
        else {
            testOutput += "FAIL (Parent references not correctly connected after delete. See astrisk*)";
            testOutput += (this.verbose) ? msg : "";
            testOutput += (this.verbose) ? errors : "";
        }

        System.out.println(testOutput);
    }

    private void findTester() {
        boolean findTestPassed = true;
        String testOutput = String.format(FORMAT_1, "find() Test:");
        String errors = "";
        String msg = "";

        String[] testValues = {"a","b","c","d","e","f","g","h","i","j","k","l","m",
                               "n","o","p","q","r","s","t","u","v","w","x","y","z",
                               "zz", "aa", "gg",};
        
        boolean[] expectedResults = {true, true, true, true, true, false, true, true, true, true, true, true, false,
                                     true, false, true, false, true, true, true, true, true, true, true, true, true,
                                     false, false, false};

        msg += "\n" + INDENT_WIDTH_1 + "Finding the following values:";
        try {
            for (int i = 0; i < testValues.length; i++) {
                boolean actual = bst.find(testValues[i]);
                
                if (actual != expectedResults[i]) {
                    findTestPassed = false;
                    msg += String.format(FORMAT_3, "*find(" + testValues[i] + ")", "Expected: " + expectedResults[i], "Actual: " + actual);
                }
                else {
                	msg += String.format(FORMAT_3, "find(" + testValues[i] + ")", "Expected: " + expectedResults[i], "Actual: " + actual);
                }
            }
        }
        catch (Exception ex) {
        	testOutput += "FAIL (" + ex + ")";

            errors += handleException(ex);

            testOutput += (this.verbose) ? msg : "";
            testOutput += (this.verbose) ? errors : "";
            System.out.println(testOutput);
            return;
        }

        if (findTestPassed) {
            testOutput += "PASS";
            
        }
        else {
            testOutput += "FAIL (find() not correct.  See asterisk *)";
        }
        testOutput += (this.verbose) ? msg : "";
        System.out.println(testOutput);
    }

    private void leafTester() {
    	//TODO: Refactor
        boolean leafTestPassed = true;
        String testOutput = "isLeaf() Test:\t\t\t\t\t";
        String errors = "";

        boolean[] expectedResults = {true, false, true, false, false, true, false, true, false, true, false, true,
                false, true, false, false, false, true, false, false, false, true};

        try {
            for (int i = 0; i < this.inorderList.size(); i++) {
                boolean actual = bst.isLeaf(inorderList.get(i));

                if (actual != expectedResults[i]) {
                    leafTestPassed = false;

                    errors += "\n\t\t*isLeaf(" + this.inorderList.get(i).data + ") Expected:\t" + expectedResults[i];
                    errors += "\n\t\t*isLeaf(" + this.inorderList.get(i).data + ") Actual:\t" + actual;
                }
                else {
                    errors += "\n\t\tisLeaf(" + this.inorderList.get(i).data + ") Expected:\t" + expectedResults[i];
                    errors += "\n\t\tisLeaf(" + this.inorderList.get(i).data + ") Actual:\t" + actual;
                }
            }
        }
        catch (Exception ex) {
            testOutput += "FAIL (" + ex + ")";

            if (verbose) {
                StackTraceElement[] stackTrace = ex.getStackTrace();

                for (int i = 0 ; i < stackTrace.length ; i++) {
                    errors += "\t" + stackTrace[i] + "\n";
                }
            }
            testOutput += (this.verbose) ? errors : "";
            System.out.println(testOutput);
            return;
        }

        if (leafTestPassed) {
            testOutput += "PASS";
        }
        else {
            testOutput += "FAIL (isLeaf() not correct. See asterisk *)" + ((verbose) ? errors : "");
        }

        System.out.println(testOutput);
    }

    private void leftChildTester() {
    	//TODO: Refactor
        boolean leftChildTestPassed = true;
        String testOutput = "isLeftChild() Test:\t\t\t\t";
        String errors = "";

        boolean[] expectedResults = {true, true, true, true, false, true, true, false, false, false, false, true,
                true, true, false, false, true, true, false, true, false, false};

        try {
            for (int i = 0; i < this.inorderList.size(); i++) {
                boolean actual = bst.isLeftChild(inorderList.get(i));
                if (actual != expectedResults[i]) {
                    leftChildTestPassed = false;

                    errors += "\n\t\t*isLeftChild(" + this.inorderList.get(i).data + ") Expected:\t" + expectedResults[i];
                    errors += "\n\t\t*isLeftChild(" + this.inorderList.get(i).data + ") Actual:\t" + actual;
                }
                else {
                    errors += "\n\t\tisLeftChild(" + this.inorderList.get(i).data + ") Expected:\t" + expectedResults[i];
                    errors += "\n\t\tisLeftChild(" + this.inorderList.get(i).data + ") Actual:\t" + actual;
                }
            }
        }
        catch (Exception ex) {
            testOutput += "FAIL (" + ex + ")";

            if (verbose) {
                StackTraceElement[] stackTrace = ex.getStackTrace();

                for (int i = 0 ; i < stackTrace.length ; i++) {
                    errors += "\t" + stackTrace[i] + "\n";
                }
            }
            testOutput += (this.verbose) ? errors : "";
            System.out.println(testOutput);
            return;
        }

        if (leftChildTestPassed) {
            testOutput += "PASS";
        }
        else {
            testOutput += "FAIL (isLeftChild() not correct. See asterisk *)" + ((verbose) ? errors : "");
        }

        System.out.println(testOutput);
    }

    private void rightChildTester() {
    	//TODO: Refactor
        boolean rightChildTestPassed = true;
        String testOutput = "isRightChild() Test:\t\t\t";
        String errors = "";

        boolean[] expectedResults = {false, false, false, false, true, false, false, true, true, true, false, false,
                false, false, true, true, false, false, true, false, true, true};

        try {
            for (int i = 0; i < this.inorderList.size(); i++) {
                boolean actual = bst.isRightChild(inorderList.get(i));

                if (actual != expectedResults[i]) {
                    rightChildTestPassed = false;

                    errors += "\n\t\t*isRightChild(" + this.inorderList.get(i).data + ") Expected:\t" + expectedResults[i];
                    errors += "\n\t\t*isRightChild(" + this.inorderList.get(i).data + ") Actual:\t" + actual;
                }
                else {
                    errors += "\n\t\tisRightChild(" + this.inorderList.get(i).data + ") Expected:\t" + expectedResults[i];
                    errors += "\n\t\tisRightChild(" + this.inorderList.get(i).data + ") Actual:\t" + actual;
                }
            }
        }
        catch (Exception ex) {
            testOutput += "FAIL (" + ex + ")";

            if (verbose) {
                StackTraceElement[] stackTrace = ex.getStackTrace();

                for (int i = 0 ; i < stackTrace.length ; i++) {
                    errors += "\t" + stackTrace[i] + "\n";
                }
            }
            testOutput += (this.verbose) ? errors : "";
            System.out.println(testOutput);
            return;
        }

        if (rightChildTestPassed) {
            testOutput += "PASS";
        }
        else {
            testOutput += "FAIL (isRightChild() not correct. See asterisk *)" + ((verbose) ? errors : "");
        }

        System.out.println(testOutput);
    }

    

    private void preorderTester() {
    	//TODO: Refactor
        boolean preorderTestPassed = false;
        String testOutput = "preorder() Test:\t\t\t\t";
        String errors = "";

        try {
            //Get the inorder traversal of the data (should be the alphabet from a - z).
            String expected = "lbaedcjhgiktpnsryxuwvz";

            ArrayList<String> preorder = this.bst.preorder();

            String results = "";

            for (int i = 0 ; i < preorder.size() ; i++) {
                results += preorder.get(i);
            }

            //Test to make sure order is correct.
            if (expected.equals(results)) {
                preorderTestPassed = true;
            }
            else {
                errors += "\n\t\tExpected Preorder:\t" + expected;
                errors += "\n\t\tResult Preorder:\t\t" + results;
            }
        }
        catch (Exception ex) {
            errors += "\n";
            testOutput += "FAIL (" + ex + ")";

            if (verbose) {
                StackTraceElement[] stackTrace = ex.getStackTrace();

                for (int i = 0; i < stackTrace.length; i++) {
                    errors += "\n\t" + stackTrace[i];
                }
            }

            testOutput += (this.verbose) ? errors : "";
            System.out.println(testOutput);
        }

        if (preorderTestPassed) {
            testOutput += "PASS";
        }
        else {
            testOutput += "FAIL (preorder ordering not correct.)" + ((verbose) ? errors : "");
        }
        System.out.println(testOutput);
    }

    private void inorderTester() {
    	//TODO: Refactor
        boolean inorderTestPassed = false;
        String testOutput = "inorder() Test:\t\t\t\t\t";
        String errors = "";

        try {
            //Get the inorder traversal of the data (should be the alphabet from a - z).
            String expected = "abcdeghijklnprstuvwxyz";

            ArrayList<String> inorder = this.bst.inorder();

            String results = "";

            for (int i = 0 ; i < inorder.size() ; i++) {
                results += inorder.get(i);
            }

            //Test to make sure order is correct.
            if (expected.equals(results)) {
                inorderTestPassed = true;
            }
            else {
                errors += "\n\t\tExpected Inorder:\t" + expected;
                errors += "\n\t\tResult Inorder:\t\t" + results;
            }
        }
        catch (Exception ex) {
            errors += "\n";
            testOutput += "FAIL (" + ex + ")";

            if (verbose) {
                StackTraceElement[] stackTrace = ex.getStackTrace();

                for (int i = 0; i < stackTrace.length; i++) {
                    errors += "\n\t" + stackTrace[i];
                }
            }

            testOutput += (this.verbose) ? errors : "";
            System.out.println(testOutput);
        }

        if (inorderTestPassed) {
            testOutput += "PASS";
        }
        else {
            testOutput += "FAIL (inorder ordering not correct.)" + ((verbose) ? errors : "");
        }
        System.out.println(testOutput);
    }

    private void postorderTester() {
    	//TODO: Refactor
        boolean postorderTestPassed = false;
        String testOutput = "postorder() Test:\t\t\t\t";
        String errors = "";

        try {
            //Get the inorder traversal of the data (should be the alphabet from a - z).
            String expected = "acdgihkjebnrspvwuxzytl";

            ArrayList<String> postorder = this.bst.postorder();

            String results = "";

            for (int i = 0 ; i < postorder.size() ; i++) {
                results += postorder.get(i);
            }

            //Test to make sure order is correct.
            if (expected.equals(results)) {
                postorderTestPassed = true;
            }
            else {
                errors += "\n\t\tExpected Postorder:\t\t" + expected;
                errors += "\n\t\tResult Postorder:\t\t" + results;
            }
        }
        catch (Exception ex) {
            errors += "\n";
            testOutput += "FAIL (" + ex + ")";

            if (verbose) {
                StackTraceElement[] stackTrace = ex.getStackTrace();

                for (int i = 0; i < stackTrace.length; i++) {
                    errors += "\n\t" + stackTrace[i];
                }
            }

            testOutput += (this.verbose) ? errors : "";
            System.out.println(testOutput);
        }

        if (postorderTestPassed) {
            testOutput += "PASS";
        }
        else {
            testOutput += "FAIL (postorder ordering not correct.)" + ((verbose) ? errors : "");
        }
        System.out.println(testOutput);
    }

    private void breadthfirstTester() {
    	//TODO: Refactor
        boolean breadthFirstTestPassed = false;
        String testOutput = "breadthfirst() Test:\t\t\t";
        String errors = "";

        try {
            //Get the inorder traversal of the data (should be the alphabet from a - z).
            String expected = "lbtaepydjnsxzchkrugiwv";

            ArrayList<String> breadthfirst = this.bst.breadthfirst();

            String results = "";

            for (int i = 0 ; i < breadthfirst.size() ; i++) {
                results += breadthfirst.get(i);
            }

            //Test to make sure order is correct.
            if (expected.equals(results)) {
                breadthFirstTestPassed = true;
            }
            else {
                errors += "\n\t\tExpected Breadthfirst:\t\t" + expected;
                errors += "\n\t\tResult Breadthfirst:\t\t" + results;
            }
        }
        catch (Exception ex) {
            errors += "\n";
            testOutput += "FAIL (" + ex + ")";

            if (verbose) {
                StackTraceElement[] stackTrace = ex.getStackTrace();

                for (int i = 0; i < stackTrace.length; i++) {
                    errors += "\n\t" + stackTrace[i];
                }
            }

            testOutput += (this.verbose) ? errors : "";
            System.out.println(testOutput);
        }

        if (breadthFirstTestPassed) {
            testOutput += "PASS";
        }
        else {
            testOutput += "FAIL (breadthfirst ordering not correct.)" + ((verbose) ? errors : "");
        }
        System.out.println(testOutput);
    }









    private String myInorder(BSTNode<String> root) {
        this.inorderList = new ArrayList<>(26);
        return myInorder(root, new String(""));
    }

    /**
     * Inorder method used to test the results of insert and the array constructor.
     * @param node      The current node being considered in the recursion.
     * @param results   The string storing each visited value.
     * @return          The result string.
     */
    private String myInorder(BSTNode<String> node, String results) {
        if (node != null) {
            results = myInorder(node.leftChild, results);
            results += node.data;
            this.inorderList.add(node);
            results = myInorder(node.rightChild, results);
        }

        return results;
    }

    private ArrayList<BSTNode<String>> filterLeaves() {
        ArrayList<BSTNode<String>> leaves = new ArrayList<>();
        //Traverse through inorder list
        for (int i = 0 ; i < this.inorderList.size() ; i++) {
            BSTNode<String> current = this.inorderList.get(i);
            if (current.leftChild == null && current.rightChild == null) {
                leaves.add(current);
            }
        }

        return leaves;
    }

    /**
     * Handles the exception in each method.  All exceptions are handled the same.
     *
     * @return A string containing the Stack trace.
     */
    private String handleException(Exception ex) {
        String errors = "";

        if (verbose) {
            StackTraceElement[] stackTrace = ex.getStackTrace();

            for (int i = 0; i < stackTrace.length; i++) {
                errors += "\n   " + stackTrace[i];
            }
        }

        return errors;
    }
}


//leaves: a c e g i k o r v z
//leaves: a c g i k n r v z