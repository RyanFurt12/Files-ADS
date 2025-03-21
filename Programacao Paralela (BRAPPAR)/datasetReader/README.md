# Projeto: Mapeamento de Ingredientes com MPI

Este projeto em **C** utiliza a **MPI** (Message Passing Interface) para processar um grande conjunto de dados de receitas e identificar:

- Os 5 ingredientes mais frequentes.
- A quantidade de vezes que um ingrediente específico aparece.

Utilizando técnicas de processamento paralelo, o projeto distribui a carga de trabalho entre múltiplos processos, tornando-o eficiente mesmo para conjuntos de dados massivos.

## Autores

- [Agatha Rizzo Cezar - BP3048705](https://www.github.com/AgathaRizzo)
- [Laura Naomi Ibusuki Hirano - BP3034348](https://www.github.com/Naomisz12)
- [Ryan Furtado de Almeida - BP3044165](https://www.github.com/RyanFurt12)

## Como Funciona

1. O programa carrega um dataset de receitas no formato CSV.
2. O programa pede qual ingrediente deseja contar individualmente.
3. Com a ajuda de MPI, os dados são distribuídos entre diferentes processos.
4. Cada processo extrai os ingredientes de suas receitas.
5. Estes contam a frequência dos ingredientes e os envia para o processo principal.
6. O processo principal agrega os resultados e apresenta o Top 5 ingredientes mais frequentes e a quantidade de vezes que um ingrediente específico aparece.

## Exemplo de Dataset

Aqui está um exemplo de uma entrada do [dataset de receitas](https://recipenlg.cs.put.poznan.pl/dataset):

```csv
,title,ingredients,directions,link,source,NER
481071,Pigs In A Blanket,"[""1 pkg. wieners"", ""1 can crescent rolls"", ""1 slice Cheddar cheese""]","[""Split wieners lengthwise almost all the way through."", ""Cut cheese in strips 1/4-inch thick."", ""Place inside wieners."", ""Starting at the short corner of roll, roll each around a wiener."", ""Place on cookie sheet and broil until cheese is bubbly.""]",www.cookbooks.com/Recipe-Details.aspx?id=288949,Gathered,"[""wieners"", ""crescent rolls"", ""Cheddar cheese""]"
```
A entrada contém:
1. title: Nome da receita.
2. ingredients: Lista de ingredientes.
3. directions: Instruções para preparo.
4. link: Link para mais informações.
5. source: Fonte da receita.
6. NER (Named Entity Recognition): Entidades extraídas, como ingredientes.

## Como Rodar o Projeto
### - Pré-requisitos
- Baixar o [dataset de receitas](https://recipenlg.cs.put.poznan.pl/dataset) e adicionar na pasta junto com os arquivos .c com o nome "full_dataset.csv".
- MPI (Message Passing Interface) instalado no seu sistema, recomendo utilizar o [Mpich](https://www.mpich.org/).
- Compilar o código no seu Sistema operacional.

### - Instalar MPI (se não tiver instalado):
- No Ubuntu/Debian: ```sudo apt install mpich```
- No MacOS (via Homebrew): ```brew install mpich```

### - Compilar e Executar o código: 
No terminal, dentro da pasta do projeto, execute o seguinte comando:

```bash
  mpicc -o main full_exercise.c 
  mpiexec -n 6 ./main
```

O programa irá perguntar qual ingrediente quer procurar, e executar conforme exemplo:
```bash
Digite o nome do ingrediente que deseja contar: broccoli

Top 5 ingredientes mais usados:
- salt: 890714
- sugar: 620013
- butter: 493808
- flour: 466086
- eggs: 401266

Total de aparições de 'broccoli': 23605
Tempo de execução: 8.3677 s
```
