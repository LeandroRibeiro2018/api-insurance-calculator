pipeline {
    agent any

    environment {
        // Variáveis globais para uso no pipeline
        DOCKER_IMAGE_NAME = 'api-insurance-calculator'
        DOCKER_IMAGE_TAG = '6'
        DOCKERFILE_PATH = './Dockerfile'
    }

    stages {
        stage('Preparar Ambiente') {
            steps {
                echo 'Preparando ambiente...'
                script {
                    // Verifica se o Docker está instalado
                    def dockerInstalled = sh(script: 'docker --version', returnStatus: true) == 0
                    if (!dockerInstalled) {
                        error "Docker não está instalado no ambiente do Jenkins"
                    }
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                echo "Construindo imagem Docker: ${DOCKER_IMAGE_NAME}:${DOCKER_IMAGE_TAG}"
                // Constrói a imagem Docker
                script {
                    sh "docker build -t ${DOCKER_IMAGE_NAME}:${DOCKER_IMAGE_TAG} -f ${DOCKERFILE_PATH} ."
                }
            }
        }

        stage('Push Docker Image') {
            steps {
                echo "Realizando push da imagem Docker para o repositório"
                // Faz o push da imagem para o repositório Docker (certifique-se que está autenticado no Docker)
                script {
                    sh "docker push ${DOCKER_IMAGE_NAME}:${DOCKER_IMAGE_TAG}"
                }
            }
        }

        stage('Deploy Docker') {
            steps {
                echo "Iniciando o container Docker com a imagem ${DOCKER_IMAGE_NAME}:${DOCKER_IMAGE_TAG}"
                // Inicia o container Docker
                script {
                    try {
                        sh "docker run -d --name ${DOCKER_IMAGE_NAME} ${DOCKER_IMAGE_NAME}:${DOCKER_IMAGE_TAG}"
                    } catch (Exception e) {
                        echo "Erro ao iniciar o container: ${e.getMessage()}"
                        error("Falha ao iniciar o container Docker")
                    }
                }
            }
        }
    }

    post {
        always {
            echo 'Limpando containers antigos...'
            // Limpa containers antigos para evitar acúmulo
            sh "docker rm -f ${DOCKER_IMAGE_NAME} || true"
            echo 'Pipeline concluído.'
        }
    }
}
