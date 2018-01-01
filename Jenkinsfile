node{
    step([$class: 'WsCleanup'])

    agent any

    triggers {
        pollSCM('H/5 * * * *')
    }

    environment {
        DMALL_DOCKER_REGISTRY='ec2-52-80-144-157.cn-north-1.compute.amazonaws.com.cn:5000'
        DEV_RANCHER_SERVER='http://ec2-54-222-228-139.cn-north-1.compute.amazonaws.com.cn:8080/v2-beta/projects/1a7'
    }

    stage('Checkout') {
        step([$class: 'WsCleanup'])
        git credentialsId: 'git-viewer', url: 'git@gitee.com:tws-micro-service/dmall-product-service.git', branch: 'release'
    }

    stage('Build') {
        sh './gradlew clean build'
    }

    stage('Check') {
        parallel (
            "Findbugs" : {
                echo 'Findbugs is finished.'
            },
            "Checkstyle" : {
                echo 'Checkstyle is finished.'
            },
            "PMD" : {
                echo 'PMD is finished.'
            }
        )
    }

    stage('Test') {
        sh './gradlew test'
    }

    stage('Docker image') {
        sh './genImages.sh'
    }

    stage('Deploy to DEV') {
        sh './deployToDEV.sh'
    }

    stage('PublishStubs'){
        steps {
            sh './gradlew :publishStubsPublicationToMavenRepository'
        }
    }

    stage('TrigerStubServer'){
        steps {
            build 'dmall-product-stub-service'
        }
    }
}