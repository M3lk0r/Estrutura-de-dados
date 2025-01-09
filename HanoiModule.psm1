function Solve-Hanoi {
    param (
        [int]$n,
        [string]$source,
        [string]$target,
        [string]$aux,
        [ref]$moveCount,
        [bool]$printMoves
    )

    if ($n -eq 1) {
        $moveCount.Value++
        if ($printMoves) {
            Write-Output "Mover disco de $source para $target"
        }
    }
    else {
        Solve-Hanoi -n ($n - 1) -source $source -target $aux -aux $target -moveCount $moveCount -printMoves $printMoves
        $moveCount.Value++
        if ($printMoves) {
            Write-Output "Mover disco de $source para $target"
        }
        Solve-Hanoi -n ($n - 1) -source $aux -target $target -aux $source -moveCount $moveCount -printMoves $printMoves
    }
}

function Execute-Hanoi {
    param (
        [int]$totalDiscs # Número total de discos
    )

    if ($totalDiscs -le 10) {
        # Usar algoritmo recursivo e imprimir movimentos
        $printMoves = $true
    }
    elseif ($totalDiscs -le 30) {
        # Usar algoritmo recursivo sem imprimir movimentos
        $printMoves = $false
    }
    else {
        # Para discos acima de 30, utilizaremos a fórmula para contar movimentos
        $printMoves = $false
    }

    Write-Output "`nResolvendo Torres de Hanói com $totalDiscs discos..." 

    $startTime = Get-Date
    if ($totalDiscs -le 30) {
        # Inicializar contador de movimentos
        $moveCount = 0

        Solve-Hanoi -n $totalDiscs -source "A" -target "C" -aux "B" -moveCount ([ref]$moveCount) -printMoves $printMoves
        $endTime = Get-Date

        $elapsedTime = $endTime - $startTime

        # Formatar tempo decorrido
        $formattedTime = "{0:hh\:mm\:ss\.ff}" -f $elapsedTime

        return @{
            DiskCount   = $totalDiscs
            MoveCount   = $moveCount
            ElapsedTime = $formattedTime
        }
    }
    else {
        # Usar fórmula para contar movimentos
        $moveCount = [math]::Pow(2, $totalDiscs) - 1
        $endTime = Get-Date

        $elapsedTime = $endTime - $startTime

        # Formatar tempo decorrido
        $formattedTime = "{0:hh\:mm\:ss\.ff}" -f $elapsedTime

        return @{
            DiskCount   = $totalDiscs
            MoveCount   = $moveCount
            ElapsedTime = $formattedTime
        }
    }
}