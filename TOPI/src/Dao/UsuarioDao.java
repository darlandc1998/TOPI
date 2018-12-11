package Dao;

import Modelos.Usuario;
import Utils.UtilPassword;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDao {
    
    private final Connection conexao;

    public UsuarioDao(Connection conexao) {
        this.conexao = conexao;
    }
    
    public void createLogin(Usuario usuario) throws SQLException{
        try (PreparedStatement ps = conexao.prepareStatement("insert into usuario (login, senha) values (?,?)")) {
            ps.setString(1, usuario.getLogin());
            ps.setString(2, UtilPassword.criptografarSenha(usuario.getSenha()));
            ps.executeUpdate();
        }
    }
    
    public void insert(Usuario usuario) throws SQLException {
        try (PreparedStatement ps = conexao.prepareStatement("insert into usuario (nome, sobrenome, email, data_nascimento, sexo, cpf, estado_civil, renda_mensal, login, senha) values (?,?,?,?,?,?,?,?,?,?)")) {
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getSobrenome());
            ps.setString(3, usuario.getEmail());
            ps.setTimestamp(4, new java.sql.Timestamp(usuario.getDtNascimento().getTime()));
            ps.setString(5, usuario.getSexo());
            ps.setString(6, usuario.getCpf());
            ps.setString(7, usuario.getEstadoCivil());
            ps.setDouble(8, usuario.getRendaMensal());
            ps.setString(9, usuario.getLogin().replace(".", "").replace("-", ""));
            ps.setString(10, UtilPassword.criptografarSenha(usuario.getSenha()));
            ps.executeUpdate();
        }
    }
    
    public void update(Usuario usuario) throws SQLException{
        try (PreparedStatement ps = conexao.prepareStatement("update usuario set nome  = ?, sobrenome = ?, email = ?, data_nascimento = ?, sexo = ?, cpf = ?, estado_civil = ?, renda_mensal = ? where codigo = ?")) {
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getSobrenome());
            ps.setString(3, usuario.getEmail());
            ps.setTimestamp(4, new java.sql.Timestamp(usuario.getDtNascimento().getTime()));
            ps.setString(5, usuario.getSexo());
            ps.setString(6, usuario.getCpf().replace(".", "").replace("-", ""));
            ps.setString(7, usuario.getEstadoCivil());
            ps.setDouble(8, usuario.getRendaMensal());            
            ps.setInt(9, usuario.getCodigo());
            ps.executeUpdate();
        }
    }
    
    public void delete(Usuario usuario) throws SQLException{
        try (PreparedStatement ps = conexao.prepareStatement("delete from usuario where codigo = ?")) {
            ps.setInt(1, usuario.getCodigo());
            ps.executeUpdate();
        }
    }
    
    public List<Usuario> getList() throws SQLException{
        List<Usuario> usuarios = new ArrayList<>();
        PreparedStatement ps = conexao.prepareStatement("select * from movimentacao");
        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()){
                Usuario usuario = new Usuario();
                usuario.setCodigo(rs.getInt("codigo"));
                usuario.setNome(rs.getString("nome"));
                usuario.setSobrenome(rs.getString("sobrenome"));
                usuario.setEmail(rs.getString("email"));
                usuario.setDtNascimento(rs.getTimestamp("data_nascimento"));
                usuario.setSexo(rs.getString("sexo"));
                usuario.setCpf(rs.getString("cpf"));
                usuario.setEstadoCivil(rs.getString("estado_civil"));
                usuario.setRendaMensal(rs.getDouble("renda_mensal"));
                usuario.setLogin(rs.getString("login"));
                usuario.setSenha(rs.getString("senha"));
                usuarios.add(usuario);
            }
        } finally {
            ps.close();           
        }        
        return usuarios;
    }
    
    public Usuario getObject(Usuario usuario) throws SQLException{
        PreparedStatement ps = conexao.prepareStatement("select * from usuario where codigo = ?");
        ps.setInt(1, usuario.getCodigo());
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()){
                Usuario usuarioQuery = new Usuario();
                usuarioQuery.setCodigo(rs.getInt("codigo"));
                usuarioQuery.setNome(rs.getString("nome"));
                usuarioQuery.setSobrenome(rs.getString("sobrenome"));
                usuarioQuery.setEmail(rs.getString("email"));
                usuarioQuery.setDtNascimento(rs.getTimestamp("data_nascimento"));
                usuarioQuery.setSexo(rs.getString("sexo"));
                usuarioQuery.setCpf(rs.getString("cpf"));
                usuarioQuery.setEstadoCivil(rs.getString("estado_civil"));
                usuarioQuery.setRendaMensal(rs.getDouble("renda_mensal"));
                usuarioQuery.setLogin(rs.getString("login"));
                usuarioQuery.setSenha(rs.getString("senha"));
                return usuarioQuery;
            }
        } finally {
            ps.close();           
        }        
        return null;
    }
    
    public boolean existsUser(Usuario usuario) throws SQLException{
        PreparedStatement ps = conexao.prepareStatement("select 1 from usuario where login = ?");
        ps.setString(1, usuario.getLogin());
        try (ResultSet rs = ps.executeQuery()){
            return rs.next();
        } 
    }
    
    public boolean existsUserLogin(Usuario usuario) throws SQLException{
        PreparedStatement ps = conexao.prepareStatement("select 1 from usuario where login = ? and senha = ?");
        ps.setString(1, usuario.getLogin());
        ps.setString(2, UtilPassword.criptografarSenha(usuario.getSenha()));
        try (ResultSet rs = ps.executeQuery()){
            return rs.next();
        } 
    }
    
     public Integer getIdUserByEmail(String login) throws SQLException{
        PreparedStatement ps = conexao.prepareStatement("select codigo from usuario where login = ?");
        ps.setString(1, login);
        try (ResultSet rs = ps.executeQuery()){
            if (rs.next()){
                return rs.getInt("codigo");
            }
        } 
        return null;
    }
     
    public boolean isPrimeiraVezLogado(String login) throws SQLException{
        PreparedStatement ps = conexao.prepareStatement("select sexo from usuario where login = ?");
        ps.setString(1, login);
        try (ResultSet rs = ps.executeQuery()){
            if (rs.next()){
                return rs.getString("sexo") == null;
            }
        } 
        return false;
    } 
    
    public Double getSalarioUserByEmail(String login) throws SQLException{
        PreparedStatement ps = conexao.prepareStatement("select renda_mensal from usuario where login = ?");
        ps.setString(1, login);
        try (ResultSet rs = ps.executeQuery()){
            if (rs.next()){
                return rs.getDouble("renda_mensal");
            }
        } 
        return null;
    }
    
}
