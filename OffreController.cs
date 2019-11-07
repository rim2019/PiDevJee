using Data;
using Domain.entities;
using Service;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using WebApp.Models;

namespace WebApp.Controllers
{
    public class OffreController : Controller
    {
        // GET: oooo
        OffreService OS;
        ProduitService PS;

        public OffreController()
        {
            OS = new OffreService();
            PS = new ProduitService();
        }

        [HttpGet]
        public ActionResult Index(OffreModels om)
        {
          return View(new OffreModels
            {
                offre = new Offre(),
                produit = new Produit(),
                ListProduits = PS.GetAll()
            });
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult CreateOffre(OffreModels om)
        {
            if (ModelState.IsValid)
            {
                Produit pp = new Produit();

                using (Context conn = new Context())
                {
                    foreach (var item in conn.Product)
                    {
                        pp = item;
                    }

                    om.offre.NouveauPrix = pp.Prix - ((pp.Prix * om.offre.PourcentageDeReduction) / 100);
                  //  OS.Add(om.offre);
                    //OS.Commit();
                    conn.Offres.Add(om.offre);
                    conn.SaveChanges();
                    return RedirectToAction("Affichage", "Offre");
                }

            }
            else
                return RedirectToAction("Index", "Offre");

        }

        public ActionResult Affichage()
        {
            return View(OS.GetAll());

        }

        // GET: Offre/Edit/2
        [HttpGet]
        public ActionResult Edit(int id)
        {
            return View(OS.GetById(id));
        }
        //*124# offre
        // POST: Offre/AddOrEdit/2
        [HttpPost]
        public ActionResult Edit(int id, Offre p)
        {
            if (ModelState.IsValid)
            {
                Offre x = new Offre();

                x = OS.GetAll().Where(a => a.IdOffresProduit == p.IdOffresProduit).FirstOrDefault();

                x.NouveauPrix = p.NouveauPrix;
                x.PourcentageDeReduction = p.PourcentageDeReduction;
                x.QtDeProduit = p.QtDeProduit;
                x.DateDebut = p.DateDebut;
                x.DateFin = p.DateFin;

                OS.Update(x);
                OS.Commit();

                return RedirectToAction("Affichage");
            }
            else
                return RedirectToAction("Index");
        }


        // GET: Product/Delete/5
        public ActionResult Delete(int id)
        {

            return View(OS.GetById(id));
        }

        // POST: Product/Delete/5
        [HttpPost]
        public ActionResult Delete(int id, Offre p)
        {
            p = OS.GetById(id);
            OS.Delete(p);
            OS.Commit();
            return RedirectToAction("Affichage");

        }

        // GET: Product/Details/5
        public ActionResult Details(int id)
        {
            return View(OS.GetById(id));
            //return View();

        }

    }
}
