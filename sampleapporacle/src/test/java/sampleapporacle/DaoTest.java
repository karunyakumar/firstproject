package sampleapporacle;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.repository.Repository;
import org.springframework.test.context.junit4.SpringRunner;


//import com.employee.operations.sampleapp.Entity.Employee;
//import com.employee.operations.sampleapp.repository.EmployeeRepository;


@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace= Replace.NONE)
public class DaoTest {

@Autowired
private TestEntityManager entityManager;

@Autowired
private Repository employeeRepository;

// write test cases here
@Test
public void whenFindByName_thenReturnEmployee() {
    // given
   /* Employee alex = new Employee(1,"kips",8000,"IT");
    entityManager.persist(alex);
    entityManager.flush();
 
    // when
    Employee found = employeeRepository.findOne(alex.getid());
 
    // then
    Assertions.assertThat(found.getName())
      .isEqualTo(alex.getName());*/
}
}