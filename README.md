# WordCounter-ForkJoinPool
This is a small program to count words inside files inside directories even if those files themselves contain directories.
This program also uses recursive tasks in order to improve performance. 
Inside the code you can notice the difference when running the sequential count variable that is commented instead of the ForkJoinPool variable.