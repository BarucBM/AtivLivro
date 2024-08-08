package com.atividade.livro.AtivLivro.dtos;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.math.BigInteger;

public record BookDto(@NotBlank String name, @NotNull String author, @NotNull String genre, @NotNull BigInteger yearRelease, @NotNull Integer pages) {
}
