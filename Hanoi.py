import time
import multiprocessing

def solve_hanoi(n, source, target, aux):
    """
    Resolve as Torres de Hanói usando recursão.
    
    Args:
        n (int): Número de discos.
        source (str): Pino de origem.
        target (str): Pino de destino.
        aux (str): Pino auxiliar.
    """
    if n == 1:
        return 1
    else:
        moves_left = solve_hanoi(n - 1, source, aux, target)
        moves_right = solve_hanoi(n - 1, aux, target, source)
        return moves_left + 1 + moves_right

def calculate_moves_for_all_disks(max_disks):
    """
    Calcula o número total de movimentos para resolver as Torres de Hanói para 'max_disks' discos
    utilizando multiprocessamento.
    
    Args:
        max_disks (int): Número máximo de discos.
        
    Returns:
        int: Total de movimentos para o número máximo de discos.
    """
    with multiprocessing.Pool() as pool:
        results = pool.starmap(solve_hanoi, [(n, "A", "C", "B") for n in range(1, max_disks + 1)])
        total_moves = sum(results)
    
    return total_moves

if __name__ == "__main__":
    try:
        # Solicita o número máximo de discos ao usuário
        max_disks = int(input("Digite o número máximo de discos: "))

        if max_disks < 1:
            raise ValueError("O número de discos deve ser maior que zero.")

        # Calcula o número total de movimentos usando multiprocessamento
        start_time = time.time()
        total_moves = calculate_moves_for_all_disks(max_disks)
        end_time = time.time()

        time_elapsed = end_time - start_time
        print("\nResultado final:\n")
        print(f"Para {max_disks} discos, o número total de movimentos é: {total_moves}")
        print(f"Tempo gasto: {time_elapsed:0.2f} segundos")

    except ValueError as e:
        print(f"Erro: {e}")
