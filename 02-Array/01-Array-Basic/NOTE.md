## Java 数组基础

- 创建一个新数组

    ```Java
    int[] arr = new int[10]; // 方法一
    int[] scores = new int[]{100, 99, 66}; // 方法二
    ```

- 给数组内元素赋值

  ```java
  for (int i = 0; i < arr.length; i++) {
      arr[i] = i;
  }
  
  scores[0] = 98; // 给特定一个赋值或更改值
  ```
  

- 迭代数组，查看数组内容

  ```java
  for (int score : scores) {
      System.out.println(score);
  }
  ```

  