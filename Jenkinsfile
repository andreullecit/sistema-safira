pipeline {
    agent any

    tools {
        maven "M3"
        jdk "jdk11"
    }
    stages {
        stage('build') {
            steps {
                sh 'java -version'
            }
        }
        stage('analyse') {
            steps {
                echo 'Analisei meu código com sonar'
            }
        }
        stage('unit test') {
            steps {
                echo 'Testei meu código com jUnit'
            }
        }
        stage('component test') {
            steps {
                echo 'Testei meu código com cucumber'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Fiz a entrega do código'
            }
        }
    }
}