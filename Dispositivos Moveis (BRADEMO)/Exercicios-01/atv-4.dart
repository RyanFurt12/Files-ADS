// ATIVIDADE 4. 
// Utilizando a classe Laptop do exercício anterior, crie 3 named constructors. Cada um deve criar uma instância de Laptop que configure:
// • um laptop para somente navegação na internet;
// • um laptop para uso em escritório;
// • um laptop para programação.
// Você deve decidir quais configurações serão definidas em cada named constructor. Por fim, crie instâncias de objetos Laptop utilizando cada um dos named constructor e imprima seus valores no console

class Laptop {
  int id;
  String nome;
  int ram;
  double clockCpu;

  Laptop(this.id, this.nome, this.ram, this.clockCpu);

  Laptop.navegacao()
      : id = 101,
        nome = "Laptop Navegação",
        ram = 4,
        clockCpu = 1.8;

  Laptop.escritorio()
      : id = 102,
        nome = "Laptop Escritório",
        ram = 8,
        clockCpu = 2.5;

  Laptop.programacao()
      : id = 103,
        nome = "Laptop Programação",
        ram = 16,
        clockCpu = 3.2;
}

void main() {
  List<Laptop> laptops = [
    Laptop.navegacao(), 
    Laptop.escritorio(),
    Laptop.programacao() 
  ];

  for (var l in laptops) {
    print("ID: ${l.id}, Nome: ${l.nome}, RAM: ${l.ram}GB, CPU: ${l.clockCpu}GHz");
  }
}
