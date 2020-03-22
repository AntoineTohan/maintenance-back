// #!groovy

pipeline {
    agent any
    tools {
        maven 'apache-maven-3.6.3' 
    }
    stages {
        stage("Code Checkout") {
            steps {
                git branch: 'master',
                url: 'https://github.com/AntoineTohan/maintenance-back.git'
                  }
              }
                stage("Tests") {
            steps {
                sh "mvn test"
            }
        }
                       stage("Install Dependencies") {
                                  steps {
                                        sh "mvn install"

                                       }
                                }
         stage('Code Quality') {
                   steps {
                       script {
                          def scannerHome = tool 'sonar-scanner';
                          withSonarQubeEnv("sonar-scanner") {
                          sh "${tool("sonar-scanner")}/bin/sonar-scanner"
                                       }
                        sleep(10)
                script{
                    timeout(time: 10, unit: 'MINUTES') {
                        def qg = waitForQualityGate abortPipeline: true
                        if (qg.status != 'OK') {
                            echo "Status: ${qg.status}"
                            error "Pipeline aborted due to quality gate failure: ${qg.status}"
                        }
                    }
                }
                     }
                           }
                        }
            stage("Building") {
                steps {
                    sh "mvn validate"
                    sh "mvn compile"
                    }
            }
     }
 }
