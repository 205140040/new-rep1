#! /bin/bash
sitePort=38011
projectRootPath=/root/.jenkins/jobs/xxx_all/xxx-business/business-service
siteRootName=business-service
siteName=business-service
siteRoot=/work/sites/business-service
libPath=$siteRoot/lib
webContentPath=$siteRoot/WebContent
confPath=$siteRoot/conf
template=$siteRoot/template
mainClass=com.alibaba.dubbo.container.Main

#ps -ef|grep  $siteRoot|grep -v grep|awk '{print $2}'|xargs kill -9
netstat -anp |grep $sitePort |grep -w 'java' |grep -v 'grep' | awk '{print $7}'  | awk  -F '/'  '{print $1}'|xargs kill -9
#runPid=`cat $siteRoot/$pid`
#kill $runPid

rm -rf $libPath && rm -rf $webContentPath && rm -rf $confPath

yes | cp  $projectRootPath/target/*.jar $projectRootPath/target/lib/

cp -r $projectRootPath/target/lib/ $libPath

mkdir $confPath
cp -r $projectRootPath/conf/*.properties $confPath
cp -r $projectRootPath/conf/*.xml $confPath
yes | cp -r $projectRootPath/conf/conf/offline/*.xml $confPath
yes | cp -r $projectRootPath/conf/offline/*.properties $confPath


##echo $libPath
siteClassPath=""

for file in $libPath/*
do
    if test -f $file
    then
	jarPath=`dirname $file`
	jarFileName=`basename $file`
	siteClassPath=`echo "${siteClassPath}${jarPath}/${jarFileName}:"`
    fi
done

classpath=`echo ".:${siteClassPath}"`
#echo $classpath
cd $siteRoot
##nohup java   -Xmn512m -Xms819m -Xmx819m  -Dfile.encoding=UTF-8 -Dsun.jnu.encoding=UTF-8 -Djava.ext.dirs=$libPath $mainClass  
#nohup java   -Xmn512m -Xms819m -Xmx819m -classpath $classpath  -Dfile.encoding=UTF-8 -Dsun.jnu.encoding=UTF-8   $mainClass  -console -app=$siteName  >$siteRoot/log.txt 2>&1 &
nohup java   -Xmn512m -Xms819m -Xmx819m -classpath $classpath  -Dfile.encoding=UTF-8 -Dsun.jnu.encoding=UTF-8   -Ddubbo.registry.file=$siteRoot/${siteName}.cache   $mainClass   >>$siteRoot/log.txt 2>&1 &
#echo  $! > $siteRoot/$pid
#nohup java   -Xmn512m -Xms819m -Xmx819m -classpath $classpath  -Dfile.encoding=UTF-8 -Dsun.jnu.encoding=UTF-8   -Ddubbo.registry.file=$siteRoot/${siteName}.cache   $mainClass &
