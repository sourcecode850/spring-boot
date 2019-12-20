package com.example.spring.eventandjpa;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.AbstractAggregateRoot;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "t_user")
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity extends AbstractAggregateRoot implements Serializable {

    /**
     * 建表注意事项：
     * （1） 自动建表配置的前缀没有datasource，spring.jpa.hibernate.ddl-auto=update
     * （2） private int id，不要使用int类型，使用包装类吧。另外要与Repository传递的id类型要保持一致
     * Provided id of the wrong type for class com.souche.boot.jpa.UserEntity. Expected: class java.lang.Integer, got class java.lang.Long
     * （3）建表的注释啥的，可以加在注解上面@Column(name = "id", columnDefinition = "int comment '主键'")
     * （4）可以指定主键生成策略：@GeneratedValue和@GenericGenerator注解需要如上配置 否则会出现建表不成功或者生成hibernate_sequence多余的表；
     * 如果指定主键生成策略是GenerationType.IDENTITY，也不会生成多余的hibernate_sequence表的
     *
     * @GeneratedValue(strategy = GenerationType.AUTO, generator = "uuid")
     * @GenericGenerator(name = "uuid", strategy = "uuid2")
     * <p>
     * JPA提供四种主键生成器策略
     * GenerationType.IDENTITY
     * 多数数据库支持IDENTITY列，数据库会在新行插入时自动给ID赋值，这也叫做ID自增长列
     * GenerationType.Auto
     * 把主键生成策略交给JPA厂商(Persistence Provider)，由它根据具体的数据库选择合适的策略，
     * 可以是Table/Sequence/Identity中的一种。假如数据库是Oracle，则选择Sequence
     * GenerationType.TABLE
     * 有时候为了不依赖于数据库的具体实现，在不同数据库之间更好的移植，可以在数据库中新建序列表来生成主键，
     * 序列表一般包含两个字段：第一个字段引用不 同的关系表，第二个字段是该关系表的最大序号。这样，只需要一张序列就可以用于多张表的主键生成。
     * GenerationType.SEQUENCE
     * Oracle不支持ID子增长列而是使用序列的机制生成主键ID
     * <p>
     * （5）直接使用UserRepository接口就可以完成基本的增删改查
     * （6）# 自动建表默认 MyISAM，不行，加上这个，默认使用 InnoDB
     * spring.jpa.database-platform=org.hibernate.dialect.MySQL5InnoDBDialect
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "int comment '用户id'")
    private Integer id;

    @Column(name = "name", columnDefinition = "varchar(32) comment '用户名'")
    private String username;

    @Column(name = "gender", columnDefinition = "varchar(10) comment '用户性别'")
    private String gender;

    /**
     * 状态变更
     *
     * @param username
     * @param gender
     */
    public void changeState(String username, String gender) {
        this.username = username;
        this.gender = gender;
        // 注册事件
        registerEvent(new UserDomainEvent(UserDomainEvent.UserDomainEventTypeEnum.USER_UPDATE_STATUS));
    }

}