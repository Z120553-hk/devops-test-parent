
def github_credentialsId = "a7159b34-9a98-464f-bce3-90918dbcb9e7"
def tag = "latest"
node {

    stage('拉取代码') { // for display purposes
        checkout([$class: 'GitSCM', branches: [[name: '*/master']],
        doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [],
        userRemoteConfigs: [[credentialsId: ${github_credentialsId},
        url: 'https://github.com/Z120553-hk/devops-test-parent.git']]])
    }
    stage('编译、构建镜像') {
        //定义镜像名称
        def imageName = "${project_name}:${tag}"
        //编译，构建本地镜像
        sh "mvn -f ${project_name} clean package dockerfile:build"
    }
    stage('项目部署') {
        echo '项目部署'
    }
}
