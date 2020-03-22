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
                        timeout(time: 1, unit: 'MINUTES') {
                        waitForQualityGate abortPipeline: true
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
