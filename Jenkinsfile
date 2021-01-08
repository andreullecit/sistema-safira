pipeline {
    agent any

    tools {
        maven "M3"
    }
    stages {
        stage('build') {
            steps {
                sh 'mvn clean install -DskipTests'
            }
        }
        stage('analyse') {
            steps {
                echo 'Analisei meu código com sonar'
            }
        }
        stage('unit test') {
            steps {
                echo 'mvn test -Dcoverage'
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