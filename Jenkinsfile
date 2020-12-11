
def github_credentialsId = "a7159b34-9a98-464f-bce3-90918dbcb9e7"
def tag = "latest"
def harbor_url = "112.125.27.123:8002"
def harbor_project_name = "harbortest"
def project_name = "demo1"
node {
    stage('拉取代码') { // for display purposes
        checkout([$class: 'GitSCM', branches: [[name: '*/master']],
        doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [],
        userRemoteConfigs: [[credentialsId: 'a7159b34-9a98-464f-bce3-90918dbcb9e7',
        url: 'https://github.com/Z120553-hk/devops-test-parent.git']]])
    }
    stage('编译、构建镜像') {

        //停止容器
        sh "docker stop $(docker ps -a | grep -w ${project_name}:${tag} | awk '{print $1}')"

        //删除容器
        sh "docker rm $(docker ps -a | grep -w ${project_name}:${tag} | awk '{print $1}')"

        //删除本地镜像
        sh "docker rmi $(docker images | grep -w ${project_name}:${tag} | awk '{print $3}')"

        //定义镜像名称
       def imageName = "${project_name}:${tag}"

        //编译，构建本地镜像
        sh "mvn -f ${project_name} clean package dockerfile:build"
    }
    stage('上传到Harbor镜像仓库') {
        echo '给镜像打标签'
        //给镜像打标签
      //  sh "docker tag ${imageName} ${harbor_url}/${harbor_project_name}/${imageName}"

        //上传到Harbor镜像仓库
        //登录
      //  sh "docker login -u admin -p harbor ${harbor_url}"
        //上传镜像
       // sh "docker push ${harbor_url}/${harbor_project_name}/${imageName}"
    }

    state('启动容器') {

       sh "docker run -d -p 8005:8005 --name ${imageName} ${imageName}"

    }


}
