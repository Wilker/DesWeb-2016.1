/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ticket;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 *
 * @author renan.vieira
 */
public class Produto extends AbstractRecord
{
    private static List<Produto> produtos = new ArrayList<>();
    private static int           id       = 1;
    
    private String titulo;
    private String descricao;
    private Evento evento;

    public Produto(String titulo, String descricao)
    {
        this.titulo = titulo;
        this.descricao = descricao;
    }

    public String getTitulo()
    {
        return titulo;
    }

    public String getDescricao()
    {
        return descricao;
    }

    @Override
    public void save()
    {
        super.setId(Produto.id);
        Produto.id += 1;
        Produto.produtos.add(this);
    }

    @Override
    public void delete()
    {
        Produto.produtos.remove(this);
    }

    public static Produto getById(int id)
    {
        return Produto.produtos.stream().filter(e -> e.getId() == id).findFirst().get();
    }

    public static List<Produto> selectAll()
    {
        return Produto.produtos;
    }

    public static List<Produto> where(Predicate<Produto> clause)
    {
        return Produto.produtos.stream().filter(clause).collect(Collectors.<Produto>toList());
    }

}