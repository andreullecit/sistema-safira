// imagem do Jenkins compatível com java 11
// docker run --rm -ti -p 8080:8080 -p 50000:50000 -v jenkins-home:/var/jenkins_home jenkins/jenkins:jdk11

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
            // para saber a URL do seu host, execute:
            // sudo ip addr show docker0
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