pipeline {
    agent any

    triggers {
        pollSCM('H/5 * * * *')
    }

    environment {
        DMALL_DOCKER_REGISTRY='ec2-52-80-144-157.cn-north-1.compute.amazonaws.com.cn:5000'
        DEV_RANCHER_SERVER='http://ec2-54-222-228-139.cn-north-1.compute.amazonaws.com.cn:8080/v2-beta/projects/1a7'
    }

    stages {
        stage('Checkout') {
            steps {
                step([$class: 'WsCleanup'])
                            git credentialsId: 'git-viewer', url: 'git@gitee.com:tws-micro-service/dmall-product-service.git', branch: 'release'
            }

        }

        stage('Build') {
            steps{
                sh './gradlew clean build'
            }
        }

        stage('Check') {
            parallel {
                stage('Findbugs') {
                        agent none
                        steps {
                            echo 'Findbugs is finished.'
                        }
                    }
                stage('Checkstyle') {
                        agent none
                        steps {
                            echo 'Checkstyle is finished.'
                        }
                    }
                stage('PMD') {
                        agent none
                        steps {
                            echo 'PMD is finished.'
                        }
                    }
            }
        }

        stage('Test') {
            steps{
                sh './gradlew test'
            }
        }

        stage('GenDockerImage') {
            steps{
                sh './genImages.sh'
            }
        }

        stage('DeployToDEV') {
            steps{
                withCredentials([usernamePassword(credentialsId: 'dev_rencher_api_key', passwordVariable: 'SECRET', usernameVariable: 'KEY')]) {
                    sh './deployToDEV.sh'
                }
            }
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

}