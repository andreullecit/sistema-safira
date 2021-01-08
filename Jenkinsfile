pipeline {
    agent any

    tools {
        maven "M3"
    }
    stages {
        stage('build') {
            steps {
                sh 'mvn -v'
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