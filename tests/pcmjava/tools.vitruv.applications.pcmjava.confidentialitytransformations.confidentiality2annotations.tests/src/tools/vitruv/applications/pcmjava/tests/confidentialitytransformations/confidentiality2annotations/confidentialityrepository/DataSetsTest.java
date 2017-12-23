package tools.vitruv.applications.pcmjava.tests.confidentialitytransformations.confidentiality2annotations.confidentialityrepository;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.kit.kastel.scbs.confidentiality.data.DataSet;
import tools.vitruv.applications.pcmjava.tests.confidentialitytransformations.confidentiality2annotations.ConfidentialityApplicationTest;
import tools.vitruv.applications.pcmjava.tests.confidentialitytransformations.confidentiality2annotations.util.ConfAssertions;
import tools.vitruv.applications.pcmjava.tests.confidentialitytransformations.confidentiality2annotations.util.ConfElementsCreator;

public class DataSetsTest extends ConfidentialityApplicationTest {

    @Before
    public void before() {

    }

    @After
    public void after() {

    }

    @Test
    public void testAddDataSet() throws Throwable {
        DataSet dataSet = addDataSet();
        checkDataSet(dataSet);
    }

    @Test
    public void testAddDataSetWithEmptyName() throws Throwable {
        DataSet dataSet = addDataSetWithName("");
        checkDataSet(dataSet);
    }

    @Test
    public void testAddDataSetWithNullName() throws Throwable {
        DataSet dataSet = addDataSetWithName(null);
        checkDataSet(dataSet);
    }

    @Test
    public void testAddDataSetWithEmptyId() throws Throwable {
        DataSet dataSet = addDataSetWithId("");
        checkDataSet(dataSet);
    }

    @Test
    public void testAddDataSetWithNullId() throws Throwable {
        DataSet dataSet = addDataSetWithId(null);
        checkDataSet(dataSet);
    }

    @Test
    public void testRenameDataSet() throws Throwable {
        DataSet dataSet = addDataSet();
        dataSet.setName(ConfElementsCreator.RENAME);
        saveAndSynchronizeChanges(getRootElement());
        checkDataSet(dataSet);
    }

    @Test
    public void testRenameDataSetWithEmptyName() throws Throwable {
        DataSet dataSet = addDataSet();
        dataSet.setName("");
        saveAndSynchronizeChanges(getRootElement());
        checkDataSet(dataSet);
    }

    @Test
    public void testRenameDataSetWithNullName() throws Throwable {
        DataSet dataSet = addDataSet();
        dataSet.setName(null);
        saveAndSynchronizeChanges(getRootElement());
        checkDataSet(dataSet);
    }

    @Test
    public void testChangeId() throws Throwable {
        DataSet dataSet = addDataSet();
        dataSet.setId(ConfElementsCreator.getId());
        saveAndSynchronizeChanges(getRootElement());
        checkDataSet(dataSet);
    }

    @Test
    public void testChangeIdDataSetWithNullId() throws Throwable {
        DataSet dataSet = addDataSet();
        dataSet.setId(null);
        saveAndSynchronizeChanges(getRootElement());
        checkDataSet(dataSet);
    }

    @Test
    public void testChangeIdDataSetWithEmptyId() throws Throwable {
        DataSet dataSet = addDataSet();
        dataSet.setId("");
        saveAndSynchronizeChanges(getRootElement());
        checkDataSet(dataSet);
    }

    @Test
    public void testChangeIdAndName() throws Throwable {
        DataSet dataSet = addDataSet();
        dataSet.setId(ConfElementsCreator.getId());
        saveAndSynchronizeChanges(getRootElement());
        dataSet.setName(ConfElementsCreator.RENAME);
        saveAndSynchronizeChanges(getRootElement());
        checkDataSet(dataSet);
    }

    @Test
    public void testDeleteDataSet() throws Throwable {
        DataSet dataSet = addDataSet();
        getRootElement().getDataIdentifier().remove(dataSet);
        saveAndSynchronizeChanges(getRootElement());
        ConfAssertions.assertEmptyCorrespondences(dataSet, correspondences().emptyCorrespondences(dataSet));
    }

    @Test
    public void testAddMultipleDataSets() throws Throwable {
        List<DataSet> dataSets = addDataSets(3);
        checkDataSets(dataSets);
    }

    @Test
    public void testAddAndDeleteMultipleDataSets() throws Throwable {
        List<DataSet> dataSets = addDataSets(5);
        for (DataSet dataSet : dataSets) {
            getRootElement().getDataIdentifier().remove(dataSet);
            saveAndSynchronizeChanges(getRootElement());
        }
        for (final DataSet dataSet : dataSets) {
            ConfAssertions.assertEmptyCorrespondences(dataSet, correspondences().emptyCorrespondences(dataSet));
        }
    }

    @Test
    public void testAddAndDeleteMultipleDataSetsNonMonotone() throws Throwable {
        final int amount = 5;
        final int amountToRemove = 3;
        final int amountToAddLater = 4;
        // create
        List<DataSet> dataSets = addDataSets(amount);
        List<DataSet> toRemove = addDataSets(amountToRemove);
        // delete
        for (final DataSet dataSet : toRemove) {
            getRootElement().getDataIdentifier().remove(dataSet);
            saveAndSynchronizeChanges(getRootElement());
        }
        // create again
        List<DataSet> toAddLater = addDataSets(amountToAddLater);
        checkDataSets(dataSets);
        checkDataSets(toAddLater);
        for (final DataSet dataSet : toRemove) {
            ConfAssertions.assertEmptyCorrespondences(dataSet, correspondences().emptyCorrespondences(dataSet));
        }
    }

    @Test
    public void testRenameOneOfMultipleDataSets() throws Throwable {
        List<DataSet> dataSets = addDataSets(3);
        DataSet toRename = addDataSet();
        toRename.setName(ConfElementsCreator.RENAME);
        saveAndSynchronizeChanges(getRootElement());
        checkDataSets(dataSets);
        checkDataSet(toRename);
    }
}
