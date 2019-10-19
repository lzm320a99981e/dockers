### Linux 脚本路径问题
```
$0 脚本被调用时候的路径，比如：
    bash /usr/local/test.sh -> /usr/local/test.sh 
    bash local/test.sh -> local/test.sh 
    bash test.sh -> test.sh
     
pwd 在哪个目录执行的脚本，比如：
    cd /opt
    bash /usr/local/test.sh -> /opt
    cd /usr/local
    bash /usr/local/test.sh -> /usr/local
    
dirname 截取参数路径所在的目录，比如：
    dirname /usr/local -> /usr
    dirname /usr/ -> /
    cd /usr
    dirname local/ -> .
    dirname local/share -> local
    
```