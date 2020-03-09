// #!groovy

pipeline {
        agent any
         tools {maven "maintenance-back"}
    stages {
        stage("Code Checkout") {
            steps {
                git branch: 'master',
                url: 'https://github.com/AntoineTohan/maintenance-back.git'
                  }
              }
         stage('Code Quality') {
                   steps {
                       script {
                          def scannerHome = tool 'sonar-scanner';
                          withSonarQubeEnv("sonar-scanner") {
                          sh "${tool("sonar-scanner")}/bin/sonar-scanner"
                                       }
                        timeout(time: 10, unit: 'MINUTES') {
                        waitForQualityGate abortPipeline: true
                            }
                     }
                           }
                        }

         stage("Install Dependencies") {
                                  steps {
                                        sh "mvn install"

                                       }
                                }

         stage("Building") {
                            steps {
                                sh "mvn build"

                              }
                        }
             }
     }
