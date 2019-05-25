package service;

import java.util.Collections;
import java.util.List;

import dao.CategoryDAO;
import dao.RecordDAO;
import entity.Category;
import entity.Record;

public class CategoryService {
    CategoryDAO categoryDao = new CategoryDAO();
    RecordDAO recordDao = new RecordDAO();

    /**
     * 返回消费记录的数组
     * @return
     */
    public List<Category> list(){
        //首先获取所有分类
        List<Category> cs = categoryDao.list();
        //根据分类来获取所有的消费记录
        for(Category category : cs) {
            List<Record> rs = recordDao.list(category.id);
        }
        //使用匿名表达式来排序
        Collections.sort(cs, (c1,c2)->c2.recordNumber-c1.recordNumber);

        return cs;
    }

    /**
     * 添加消费分类
     * @param name 消费分类名称
     */
    public void add(String name) {
        Category c = new Category();
        c.setName(name);
        categoryDao.add(c);
    }

    /**
     * 根据id更新消费分类名称
     * @param id 分类的id
     * @param name 分类的名称
     */
    public void update(int id,String name){
        Category c = new Category();
        c.setId(id);
        c.setName(name);
        categoryDao.update(c);
    }

    /**
     * 根据id删除消费分类
     * @param id 分类的id
     */
    public void delete(int id) {
        categoryDao.delete(id);

    }
}
