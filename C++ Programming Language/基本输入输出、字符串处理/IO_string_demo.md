# cpp IOlib 输入输出相关操作

|head file|type|
|---------|----|
|iostream|istream;ostream;iostream|
|fstream|ifstream;ofstream;fstream|
|sstream|istringstream;ostringstream;stringstream|

- cin读取数量不定的输入数据

    while(std::cin>>value) //读取数据直到遇到文件尾，字符串末尾的空白/结束符被留在流中  
    当流未遇到错误，那么检测成功。当遇到文件结束符（end-of-file EOF），或遇到一个无效输入时（例如读入的值不是一个整数），istream对象的状态会变为无效。处于无效状态的istream对象会使条件变为假。  
    win系统中，输入文件结束符的方法是敲ctrl+Z,然后按Enter或Return键；在Unix系统中，包括Mac OS X 是用Ctrl+D  

- 读写string对象

    在执行读取操作时，string对象会自动忽略开头的空白（即空格符、换行符、制表符等）并从第一个真正的字符开始读起，直到遇见下一处空白为止。

- 读取未知数量的string对象；用getline()读取一整行。

    遇到文件结束标志或非法输入则流无效。
    函数从给定的输入流中读入内容，直到遇到换行符为止（注意换行符也被读进来了），然后把所读的内容存入到那个string对象中去（注意不存换行符），也就是丢弃了换行符。只要一遇到换行符就结束读取操作并返回结果。  

    ```cpp
        string word;
        while(cin >> word)
            cout << word << endl;

        string line;
        //保留输入时的空白符
        //getline 可指定分隔符 如 getline(cin,line,' ');
        while(getline(cin,line)){
            cout << line << endl;
        }
        return 0;
    ```

- stringstream用法

    ```cpp
        #include<sstream>

        stringstream ss;
        string s = "hello string stream";
        ss << s;
        string temp;
        ss>>temp;
        cout << temp;
        //输出 hello
    ```

## cout格式化输出

流操作算子

|控制符|作用|
|-----|----|
 dec | 设置整数为十进制
 hex| 设置整数为十六进制
 oct| 设置整数为八进制
 setbase(n)| 设置整数为n进制(n=8,10,16)
 setfill(n)| 设置字符填充，c可以是字符常或字符变量
 setprecision(n)| 设置浮点数的有效数字为n位
 setw(n)| 设置字段宽度为n位
 setiosflags(ios::fixed)| 设置浮点数以固定的小数位数显示
 setiosflags(ios::scientific)  | 设置浮点数以科学计数法表示
 setiosflags(ios::left)| 输出左对齐
 setiosflags(ios::right)| 输出右对齐
 setiosflags(ios::skipws)| 忽略前导空格
 setiosflags(ios::uppercase)| 在以科学计数法输出E与十六进制输出X以大写输出，否则小写。
 setiosflags(ios::showpos)| 输出正数时显示"+"号
 setiosflags(ios::showpoint)| 强制显示小数点
 resetiosflags() |终止已经设置的输出格式状态，在括号中应指定内容

```cpp
#include<iomanip>
//输出不同进制
    cout << hex << 10 << endl;
    cout << 10 << endl;
    cout << oct << 10;
/*
a
a
12
*/

//浮点数输出指定精度
    cout << setprecision(4) << 1.1111;
    //1.111

//输出指定宽度 左右对齐
    cout << setw(6) << right << 10;
    //    10

//输出年月日
    int year = 2020;
    int month = 4;
    int day = 15;
    cout << year << '-' << setw(2) << setfill('0') << month << '-' << std::setw(2)<< std::setfill('0') << day;
    //2020-04-15

```

## cpp中的字符串

string  //需要引入头文件  
char*   //指向字符串的指针 实质上是指向字符串的首字母  
const char* //指针 指向的是一个常量字符类型（不可改内容）  
char[]  //字符数组 可以用来对应一个字符串  

```cpp
string s;
//不能读入空格
cin >> s;

//可以读入空格和制表符，以回车符作为结束标志，读入回车符但丢弃
getline(cin,s);
```

system("pause");

### 从string中获取char字符

str.at(int index);

str[index]

### string的相关操作

1. 替换 replace

2. 删除 erase

3. 插入 insert

    ```cpp
    string str = "this is a test string.";
    string str2 = "n example";

    string str3 = "sample phrase";
    string str4 = "useful";
    //从第9个字符开始 5个字符被 str2代替
    str.replace(9,5,str2);
    cout << str;    //this is an example string.
    //从第19个字符开始的 6个字符 用 str的第7个字符开始的6个字符代替
    str.replace(19,6,str3,7,6);  //this is just a phrase.
    //  用str4的前3个字符代替
    str.replace(8,6,str4,3);
    //  用3个叹号代替
    str.replace(22,1,3,'!');
    ```

4. 比较 s1 < s2  或 s1.compare(s2)//后者相等返回0 大于返回1 小于返回-1

5. 连接 s1 = s1 + s2  或 s1.append(s2)

6. 长度 str.size()

7. 查找 str.find("ab"), str.find("ab",2), str.rfind("ab",2)

8. 子串 s2 = s.substr(pos,n) 从pos开始取n个字符

9. 转换

stoi, stol, stof, stod

