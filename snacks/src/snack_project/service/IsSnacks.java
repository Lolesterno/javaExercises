package snack_project.service;

import snack_project.domain.Snack;

import java.util.List;

public interface IsSnacks {
    void addSnack(Snack snack);

    void viewSnacks();

    List<Snack> getSnacks();
}
