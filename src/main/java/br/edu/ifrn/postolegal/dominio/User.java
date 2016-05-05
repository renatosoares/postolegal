/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.postolegal.dominio;
import java.io.Serializable;
import java.util.Collection;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Builder;
/**
 *
 * @author jbull
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
public class User implements Serializable{
    private String email;
    private String name;
    private Collection<Vehicle> vehicle;
}
