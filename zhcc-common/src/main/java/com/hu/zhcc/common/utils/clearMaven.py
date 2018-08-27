import os
import shutil
from datetime import datetime

# maven仓库地址
mvnHome = "/Users/hulichao/.m2/repository"
# 删除该日期前的文件以及文件夹
deleteDateBefore = datetime(2018,8,1,0,0,0)


def listPathAndClean(pathContext):
    pathDir = os.listdir(pathContext)
    for filename in pathDir:
        filepath = os.path.join(pathContext, filename)
        currentTimeFile = datetime.fromtimestamp(os.path.getmtime(filepath))

        # 对比时间
        if deleteDateBefore > currentTimeFile:
            print("filePath:"+filepath+"-----updatetime:"+str(currentTimeFile))
            print('delete this')
            if (os.path.isdir(filepath)):
                shutil.rmtree(filepath)
            else:
                os.remove(filepath)
            continue

        # 不到期的则深入遍历
        if os.path.isdir(filepath):
            listPathAndClean(filepath)



if __name__ == '__main__':
    print(deleteDateBefore)
    print('start list should delete path')
    listPathAndClean(mvnHome)