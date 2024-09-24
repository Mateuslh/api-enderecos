package dev.mateuslh.Exception;

public class EntidadeNaoEncontradaException extends RuntimeException {
    public EntidadeNaoEncontradaException(Class<?> c) {
        super(c.getSimpleName() + " não encontrado(a).");
    }
}