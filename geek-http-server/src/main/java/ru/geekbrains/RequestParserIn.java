package ru.geekbrains;

import ru.geekbrains.domain.HttpRequest;

import java.util.Deque;

public interface RequestParserIn {
    HttpRequest parse (Deque<String> raw);
}
