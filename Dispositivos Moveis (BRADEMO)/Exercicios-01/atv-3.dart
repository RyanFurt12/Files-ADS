// ATIVIDADE 3.
// Escreva um programa em Dart para criar uma classe Laptop com as propriedades [id, nome, ram, clockCpu] e crie 3 objetos dela, imprimindo todos os detalhes.

class Laptop {
  int id;
  String nome;
  int ram;
  double clockCpu;

  Laptop(this.id, this.nome, this.ram, this.clockCpu);
}

void main() {
  List<Laptop> laptops = [
    Laptop(1, "Dell Inspiron", 8, 2.5),
    Laptop(2, "Lenovo ThinkPad", 16, 3.2),
    Laptop(3, "HP Pavilion", 12, 2.8),
  ];

  for (var laptop in laptops) {
    print("ID: ${laptop.id}, Nome: ${laptop.nome}, RAM: ${laptop.ram}GB, CPU: ${laptop.clockCpu}GHz");
  }
}
