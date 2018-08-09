package dao;

import domain.Person;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


public class PersonMapper {
    @Insert("insert into person(pid,pname,page) values(#{pid},#{pname},#{page})")
    public int add(Person person);
    @Select("select * from person where pid = #{pid}")
    public Person getPerson(int pid);

    @Update("update person set pname=#{pname},page=#{page} where pid = #{pid}")
    public int updatePerson(Person preson);

    @Delete("delete from person where pid=#{pid}")
    public int deletePerson(int pid);
}
