package pro.taskana;

import java.util.List;

import pro.taskana.exceptions.ClassificationAlreadyExistException;
import pro.taskana.exceptions.ClassificationNotFoundException;
import pro.taskana.exceptions.NotAuthorizedException;

/**
 * This class manages the classifications.
 */
public interface ClassificationService {

    /**
     * Get all available Classifications as a tree.
     * @return The List of all Classifications
     */
    List<Classification> getClassificationTree() throws NotAuthorizedException;

    /**
     * Get all Classifications with the given id.
     * Returns also older and domain-specific versions of the classification.
     *
     * @param id
     * @return List with all versions of the Classification
     */
    List<Classification> getAllClassificationsWithId(String id, String domain);

    /**
     * Get the Classification for id and domain.
     * @param id
     * @param domain
     * @return If exist: domain-specific classification, else default classification
     */
    Classification getClassification(String id, String domain) throws ClassificationNotFoundException;

    /**
     * Persist a new classification. If the classification does
     * already exist in a domain, it will just be updated.
     * @param classification
     *            the classification to insert
     * @throws ClassificationAlreadyExistException
     *            when the classification does already exists with same ID+domain.
     */
    void createClassification(Classification classification) throws ClassificationAlreadyExistException;

    /**
     * Update a Classification.
     * @param classification
     *            the Classification to update
     * @throws ClassificationNotFoundException when the classification does not exist already.
     */
    void updateClassification(Classification classification) throws ClassificationNotFoundException;

    /**
     * This method provides a query builder for quering the database.
     * @return a {@link ClassificationQuery}
     */
    ClassificationQuery createClassificationQuery();

    /**
     * Creating a new {@link Classification} with unchangeable default values.
     * It will be only generated and is not persisted until CREATE-call.
     * @return classification to specify
     */
    Classification newClassification();
}