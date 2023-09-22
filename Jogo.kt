package com.example.jogodamemoria

import kotlin.random.Random

class Jogo(private val imagens: List<String>) {
    private val tabuleiro = MutableList(16) { "" }

    init {
        if (imagens.size < 8) {
            throw IllegalArgumentException("A lista de imagens deve conter pelo menos 8 imagens.")
        }
        if (imagens.size % 2 != 0) {
            throw IllegalArgumentException("O número de imagens deve ser par.")
        }

        criarTabuleiro()
    }

    private fun criarTabuleiro() {
        val imagensEmbaralhadas = (imagens + imagens).shuffled()

        for (i in 0 until 16) {
            tabuleiro[i] = imagensEmbaralhadas[i]
        }
    }

    fun getImagemNaPosicao(posicao: Int): String {
        if (posicao < 0 || posicao >= 16) {
            throw IllegalArgumentException("Posição inválida.")
        }
        return tabuleiro[posicao]
    }
}