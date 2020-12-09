
def github_credentialsId = "a7159b34-9a98-464f-bce3-90918dbcb9e7"
def tag = "latest"
def project_name = "demo1"
node {
    stage('拉取代码') { // for display purposes
        checkout([$class: 'GitSCM', branches: [[name: '*/master']],
        doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [],
        userRemoteConfigs: [[credentialsId: 'a7159b34-9a98-464f-bce3-90918dbcb9e7',
        url: 'https://github.com/Z120553-hk/devops-test-parent.git']]])
    }
    stage('编译、构建镜像') {
        //定义镜像名称
       /// def imageName = "${project_name}:${tag}"
       def imageName = "demo1:latest"
        //编译，构建本地镜像
        sh " mvn -f demo1 clean package dockerfile:build"
       // sh "mvn -f ${project_name} clean package dockerfile:build"
    }
    stage('上传到Harbor镜像仓库') {
        echo '上传到Harbor镜像仓库'
    }


}
