# Java e JPA: Otimizações com JPA2 e Hibernate	

## Faça esse curso e...
- Entenda as dificuldades do uso do JDBC e SQL puro
- Melhore o desempenho com Cache
- Escreve consultas dinâmicas com Criteria
- Gerencie as conexões com Pool e DataSource
- Use corretamente o padrão EntityManagerInView
- Evite conflitos com Locks

## Conteúdo Detalhado

### 1. Mapeando relacionamentos Muitos-para-Muitos
- Requisitos do treinamento
- Conhecendo os relacionamentos
- Relacionamento muitos-para-muitos
- Representando esse relacionamento no banco de dados

### 2. Consultas dinâmicas com Criteria API
- O velho problema da concatenação de Strings
- Montando a consulta dinâmicas
- Usando Predicates
- Adicionando mais filtros à consulta

### 3. O comportamento Lazy e OpenEntityManagerInView
- Editando produtos
- Entendendo comportamento preguiçoso
- Ciclo da vida do EntityManager
- O padrão OpenEntityManagerInView
- Configurando OpenEntityManagerInView com Spring

### 4. Gerenciando conexões com Pool de conexão
- EntityManager por requisição?
- Muitas ou poucas conexões?
- Gerenciando conexões
- Isolando os dados de conexão com DataSource
- Conhecendo o Pool de conexões
- Configurações importante do Pool C3P0
- Limitando a quantidade de conexões

### 5. Evitando conflitos com Lock otimista
- Quem chegará primeiro?
- O que é Lock pessimista?
- Problemas com Lock Pessimista
- Resolvendo o problema com Lock Otimista
- Usando @Version
- Testando o Lock Otimista

### 6. Melhorando o desempenho com Cache
- Pensando em performance
- Conhecendo o cache de primeiro nível
- Cache para vários EntityManagers?
- Conhecendo o cache de segundo nível
- Habilitando o EhCache
- Usando o cache de segundo nível na aplicação
- Cache de Collections
- Armazenando a Categoria no cache
- Cache de queries

### 7. Caçando seus gargalos com o Hibernate Statistics
- Coletando informações sobre a camada de persistência
- Configurando o Hibernate Statistics
- Visualizando dados sobre o cache de queries:
- Outras estatísticas
