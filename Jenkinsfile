pipeline {
    agent any
    environment {
        MAVEN_OPTS = "-Dmaven.test.failure.ignore=true" // Ignora falhas de teste para que o pipeline continue e gere relatórios
    }
    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Build') {
            steps {
                echo 'Compilando o aplicativo Spring Boot...'
                bat 'mvn clean install -e -X' // Adiciona opções -e e -X para maior detalhamento nos logs
            }
        }
        stage('Test') {
            steps {
                echo 'Executando os testes...'
                bat 'mvn test -e -X' // Executa testes com logs detalhados
            }
            post {
                always {
                    archiveArtifacts artifacts: '**/target/surefire-reports/*.xml', allowEmptyArchive: true // Arquiva relatórios de teste
                    junit '**/target/surefire-reports/*.xml' // Analisa e exibe os resultados de teste no Jenkins
                }
            }
        }
        stage('Run Application') {
            when {
                expression { currentBuild.result == null || currentBuild.result == 'SUCCESS' }
            }
            steps {
                echo 'Iniciando a aplicação...'
                bat 'mvn spring-boot:run'
            }
        }
    }
    post {
        always {
            echo 'Pipeline concluído!'
        }
        failure {
            echo 'Pipeline falhou.'
        }
    }
}
