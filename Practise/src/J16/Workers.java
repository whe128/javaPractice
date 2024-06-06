package J16;

public class Workers implements Runnable {
    static final int WORK_ITEMS = 1000;
    static final int THREADS = 2;
    //these are two share resource
    int squareFounds = 0;
    int nextWorkItem = 1;

    //input an item and find its square.
    private void workHard(int workItem){
        //do a lot of computation and can be parallel for dif. work items
        System.out.println(workItem + " is being processed by "+ Thread.currentThread().getName());

        for (int i = 0; i <= (workItem/2)+1; i++) {
            //use int will lead to overflow, so we use long
            //for instance workItem = 203897
            //i = 92683, i*i = 8,590,138,489, greater than the largest int value (2,147,483,647)
            //unexpected value (203,897) == workItem
            //actually, they are not same
            long calSquare = (long)(i*i);
            if(calSquare == workItem){
                updateSquaresFound();
            }
        }
    }

    //use synchronized to realize synchronized access to the shared resource
    //when one thread access this method, this method will be blocked and other method cannot access until
    //the first thread completes the execution and release the block
    synchronized private void updateSquaresFound(){
        squareFounds++;
    }

    //use synchronized to realize synchronized access to the shared resource
    //when one thread access this method, this method will be blocked and other method cannot access until
    //the first thread completes the execution and release the block

    //update the work item
    // If you remove the synchronized keyword, there will be a race condition, for instance:
    //       Thread-1: current_work_item <- 10
    //       Thread-2: current_work_item <- 10
    //       Thread-1: updates next_work_item to 11 and returns 10
    //       Thread-1: after workHard(10), it call getNextWorkItem()
    //       Thread-1: current_work_item <- 11, update next_work_item to 12, and returns 11
    //       Thread-1: after workHard(11), it call getNextWorkItem()
    //       Thread-1: current_work_item <- 12, update next_work_item to 13, and returns 12
    //       Thread-2: resumes execution. Recall that current_work_item for it equals 10
    //       Thread-2: updates next_work_item to 11 (!!!!), and returns 10
    //must one thread complete, other thread can run, they cannot mix
    synchronized private int getNextWorkItem(){
        int currentWorkItem = nextWorkItem;
        nextWorkItem = currentWorkItem+1;
        return currentWorkItem;
    }

    /**
     * different thread will run it
     * just write the code in the thread, run
     */
    @Override
    public void run() {
        //different myTask,
        int myTask = 0;
        //read the item that need calculate the square
        //this function is synchronized-to get the next
        int localWorkItem = getNextWorkItem();
        //run within 1000
        while(localWorkItem<=WORK_ITEMS){
            //check whether it can be squared
            workHard(localWorkItem);
            //record the times run in this thread
            myTask++;
            //after finish, go the next item
            localWorkItem = getNextWorkItem();
        }
        System.out.println(Thread.currentThread().getName()+" processed " + myTask + " work items");
    }

    /**
     * in main, it just creates the thread, and the details of running code is in run.
     * @param args
     */
    public static void main(String[] args) {
        //create the task object
        Workers workers = new Workers();
        //create two thread-arrsy
        Thread[] threads = new Thread[THREADS];

        //this is where the real thread is created
        for (int i = 0; i < THREADS; i++) {
            //there use workers, this thread will run the task in the run method of the Worker class
            threads[i] = new Thread(workers,"Thread  "+ i);
        }
        //start the thread
        for (int i = 0; i < THREADS; i++) {
            threads[i].start();
        }
        //this is main thread--give the print
        System.out.println(Thread.currentThread().getName() + "is going to wait for workers");

        try {
            for (int i = 0; i < THREADS; i++) {
                //wait for all thread to finish
                threads[i].join();
            }

        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("All workers are done! We found " + workers.squareFounds+ "" +    " squares");
    }
}
