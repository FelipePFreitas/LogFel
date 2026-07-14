# 🚚 LogiRoute Microservices

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Docker](https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white)
![JWT](https://img.shields.io/badge/JWT-black?style=for-the-badge&logo=JSON%20web%20tokens)

> Ecossistema de microserviços de alta performance para controle de logística, frotas e entregas.
> Arquitetura orientada a domínios usando **Arquitetura Hexagonal**, segurança stateless baseada em **JWT** e controle de acesso granular baseado em perfis (**RBAC**).

---

## 🏛️ Arquitetura e Padrões de Projeto

Para garantir alta manutenibilidade, testabilidade e desacoplamento de tecnologia, o projeto foi estruturado seguindo padrões de engenharia de software de nível empresarial:

### 🟩 Arquitetura Hexagonal (Ports & Adapters)

Cada microserviço é dividido de forma que as regras de negócio fiquem completamente isoladas no núcleo (**Core/Domain**), sem qualquer dependência de frameworks externos (como o Spring), bancos de dados ou bibliotecas de serialização.
* **Domain (Core):** Contém as entidades de negócio e regras puras de logística.
* **Ports (Interfaces):** Definem como o mundo externo se comunica com o domínio (*Input Ports* ou *Use Cases*) e como o domínio se comunica com o mundo externo (*Output Ports* ou *SPIs*).
* **Adapters (Tecnologia):** Implementações tecnológicas concretas. Exemplos: adaptadores de entrada (REST Controllers com Spring Web) e adaptadores de saída (Repositories com Spring Data JPA, conexões MySQL ou clientes de mensageria).

### 🌐 Arquitetura de Microserviços

O sistema é distribuído em serviços independentes e focados em um único contexto delimitado (*Bounded Context*), garantindo escalabilidade horizontal:
* **Auth-Service:** Responsável pela autenticação, geração/validação de tokens JWT e cadastro de usuários.
* **Fleet-Service (Frotas):** Gerenciamento de veículos, capacidade de carga e manutenção.
* **Delivery-Service (Entregas):** Roteirização, rastreamento e distribuição de entregas por motoristas.

---

## 🛠️ Tecnologias Utilizadas (Deep Dive)

O ecossistema foi construído utilizando as melhores ferramentas do mercado Java para garantir robustez, performance e segurança:

* **Java 17 (LTS):** Utilização de recursos modernos da linguagem (como *Records*, *Pattern Matching* e *Sealed Classes*) para um código mais limpo e seguro.
* **Spring Boot 3.x:** Base para a construção dos microserviços rápidos e prontos para produção.
* **Spring Security 6 & JWT:** Controle de segurança stateless. O `Auth-Service` emite o token assinado e os demais microserviços validam esse token de forma independente através de um filtro customizado.
* **Spring Data JPA:** Abstração e persistência de dados no banco relacional.
* **MySQL:** Banco de dados relacional oficial utilizado para garantir a integridade referencial dos dados de frotas e rotas.
* **Lombok:** Redução drástica de código boilerplate (como getters, setters e construtores) nos adaptadores e DTOs.
* **Spring Boot Validation:** Validação rigorosa dos dados de entrada antes que cheguem ao domínio de logística (ex: restrições de peso, formato de placa de veículo e e-mail).
* **MapStruct 1.5+:** Essencial para a Arquitetura Hexagonal. Realiza o mapeamento ultra-performático (em tempo de compilação) entre os modelos de Domínio pura e as Entidades JPA ou DTOs de API, mantendo o domínio 100% isolado de anotações de infraestrutura.
* **Docker & Docker Compose:** Containerização de todos os serviços (MySQL, instâncias de microserviços), garantindo consistência ambiental idêntica de desenvolvimento à produção.

---

## 🔐 Controle de Permissões (RBAC)

O ecossistema utiliza o controle de acesso baseado em perfis de usuário (**Role-Based Access Control**). Cada requisição HTTP deve conter o cabeçalho `Authorization: Bearer <JWT>`.

O filtro de segurança descriptografa o payload do JWT e valida as seguintes regras através do `@PreAuthorize` do Spring Security:

| Perfil (Role) | Escopo de Acesso | Exemplo de Endpoint Protegido |
| :--- | :--- | :--- |
| 🔴 **`ROLE_ADMIN`** | Acesso irrestrito a todos os microserviços e operações administrativas. | `DELETE /api/frotas/{id}` |
| 🟡 **`ROLE_DESPACHANTE`** | Permissão para gerenciar veículos e criar/vincular rotas de entregas. | `POST /api/entregas/rotas` |
| 🟢 **`ROLE_MOTORISTA`** | Acesso limitado às suas próprias rotas e atualização de status de entrega. | `PATCH /api/entregas/{id}/status` |

## 📦 Estrutura de Diretórios de um Microserviço





Cada módulo/microserviço segue a risca a divisão de camadas da Arquitetura Hexagonal:

```text
├── domain/                  # Núcleo isolado (Sem dependências de Frameworks)
│   ├── model/               # Entidades de negócio de logística (ex: Veiculo, Rota)
│   └── usecase/             # Casos de uso (Lógica de negócios e regras)
│
├── ports/                   # Fronteiras do sistema (Interfaces)
│   ├── in/                  # Portas de Entrada (Use Cases consumidos pelos controllers)
│   └── out/                 # Portas de Saída (Interfaces para persistência ou chamadas externas)
│
└── adapters/                # Detalhes de implementação e tecnologia (Spring, JPA, etc)
    ├── in/
    │   └── web/             # REST Controllers, DTOs e Mappers (MapStruct)
    └── out/
        └── persistence/     # Repositories JPA, Entidades de banco de dados e Mappers (MapStruct)


