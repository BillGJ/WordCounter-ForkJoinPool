# WordCounter-ForkJoinPool

This is a small program to **count words** inside **files** inside **directories** even if those files themselves contain directories.
This program uses recursive tasks in order to improve performance by running multiple threads using **ForkJoinPool**.
Inside the code you can notice the difference when running the **sequential based count variable** that is commented instead of the **ForkJoinPool based count variable**.

### Usage

**Generic Usage:** WordCounter [path] [word]

**Specific Usage:** WordCounter [files/] [word]