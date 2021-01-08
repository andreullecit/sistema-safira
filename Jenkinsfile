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
                sh 'mvn sonar:sonar -Dsonar.host.url=http://172.17.0.1:9000'
            }
        }
        stage('unit test') {
            steps {
                sh 'mvn test -Dcoverage'
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